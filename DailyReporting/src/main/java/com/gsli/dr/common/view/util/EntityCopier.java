package com.gsli.dr.common.view.util;

import java.beans.PropertyDescriptor;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.core.annotation.AnnotationUtils;

import com.gsli.dr.common.util.DRContractChecker;
import com.gsli.dr.domain.generic.GenericEntity;

public class EntityCopier<E>
{
  public static Object copyEntity(GenericEntity entity)
  {
    DRContractChecker.notNull(EntityCopier.class.getName(), "copyEntity", entity);

    return copyProperties(entity, null);
  }

  public static Object copyEntity(GenericEntity src, GenericEntity dest)
  {
    DRContractChecker.notNull(EntityCopier.class.getName(), "copyEntity", src);

    DRContractChecker.notNull(EntityCopier.class.getName(), "copyEntity", dest);

    return copyProperties(src, dest);
  }

  public static List<Object> copyEntities(List<GenericEntity> entityList)
  {
    DRContractChecker.checkListEmpty(EntityCopier.class.getName(), "copyEntities", entityList);

    List<Object> copies = new ArrayList<>();
    for (GenericEntity entity : entityList) {
      copies.add(copyProperties(entity, null));
    }
    return copies;
  }

  private static Object copyProperties(GenericEntity src, GenericEntity dest) {
    BeanWrapper entityWrapper = new BeanWrapperImpl(src);
    String[] props = getFilteredProperties(entityWrapper.getPropertyDescriptors());

    Class wrapperClass = entityWrapper.getWrappedClass();
    Object copiedEntity = null;
    if (dest == null)
    {
      Object copied = BeanUtils.instantiate(wrapperClass);
      copiedEntity = copied;
    } else {
      copiedEntity = dest; }
    BeanUtils.copyProperties(src, copiedEntity, props);
    return copiedEntity;
  }

  private static String[] getFilteredProperties(PropertyDescriptor[] propertyDescs)
  {
    List filtered = new ArrayList();
    for (PropertyDescriptor propertyDescriptor : propertyDescs) {
      Method getterMethod = propertyDescriptor.getReadMethod();
      if (getterMethod == null) {
        continue;
      }
      if ((AnnotationUtils.findAnnotation(getterMethod, OneToMany.class) != null) || (AnnotationUtils.findAnnotation(getterMethod, ManyToOne.class) != null))
      {
        filtered.add(propertyDescriptor.getName());
      }

      if ((AnnotationUtils.findAnnotation(getterMethod, OneToOne.class) == null) || (AnnotationUtils.getValue(AnnotationUtils.findAnnotation(getterMethod, OneToOne.class), "fetch") != FetchType.LAZY))
      {
        continue;
      }

      filtered.add(propertyDescriptor.getName());
    }

    return ((String[])filtered.toArray(new String[filtered.size()]));
  }

  public static <E> E deepCopyBySerialization(E e)
    throws IOException, ClassNotFoundException
  {
    ByteArrayOutputStream buf = new ByteArrayOutputStream();
    ObjectOutputStream o = new ObjectOutputStream(buf);
    o.writeObject(e);

    ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buf.toByteArray()));

    return (E) in.readObject();
  }
}