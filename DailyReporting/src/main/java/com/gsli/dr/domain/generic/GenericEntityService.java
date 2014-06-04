package com.gsli.dr.domain.generic;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;

import com.gsli.dr.common.view.util.DRPageConfig;

public abstract interface GenericEntityService<T extends GenericEntity, PK extends Serializable>
{
  public abstract T findEntityById(PK paramPK);

  public abstract List<T> findAllEntities();

  public abstract T saveEntity(T paramT);

  public abstract Long countOfEntities();

  public abstract Boolean IsExists(PK paramPK);

  public abstract void deleteEntityById(PK paramPK);

  public abstract void deleteAllEntities();

  public abstract List<T> findByEntity(T paramT);

  public abstract Page<T> findByEntity(T paramT, DRPageConfig paramEPPageConfig);

  public abstract List<T> findByEntityCreatedBetween(T paramT, Date paramDate1, Date paramDate2);

  public abstract Page<T> findByEntityCreatedBetween(T paramT, Date paramDate1, Date paramDate2, DRPageConfig paramEPPageConfig);

  public abstract List<T> findAllSorted(DRPageConfig paramEPPageConfig);

  public abstract boolean validateEntity(T paramT);
}