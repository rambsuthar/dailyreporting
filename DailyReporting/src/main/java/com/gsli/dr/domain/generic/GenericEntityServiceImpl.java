package com.gsli.dr.domain.generic;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;

import com.gsli.dr.common.logger.GslLogger;
import com.gsli.dr.common.view.util.DRPageConfig;

public abstract class GenericEntityServiceImpl<T extends GenericEntity, PK extends Serializable>
  implements GenericEntityService<T, PK>
{
  private static final GslLogger gslLogger = GslLogger.getGslLogger(GenericEntityServiceImpl.class);

  public abstract GenericRepository<T, PK> getEntityRepository();

  public abstract boolean validateEntity(T paramT);

  public T findEntityById(PK entityId)
  {
    gslLogger.info("Entry : GenericEntityServiceImpl.findEntityById()");
    gslLogger.info("EntityRepository : " + getEntityRepository());
    return (getEntityRepository().findOne(entityId));
  }

  public List<T> findByEntity(T entity)
  {
    gslLogger.info("Entry : GenericEntityServiceImpl.findByEntity()");
    gslLogger.info("EntityRepository : " + getEntityRepository());
    return getEntityRepository().findByEntity(entity);
  }

  public List<T> findAllEntities()
  {
    gslLogger.info("Entry : GenericEntityServiceImpl.findAllEntities()");
    gslLogger.info("EntityRepository : " + getEntityRepository());
    return getEntityRepository().findAll();
  }

  public T saveEntity(T GenericEntity)
  {
    gslLogger.info("Entry : GenericEntityServiceImpl.saveEntity()");
    gslLogger.info("EntityRepository : " + getEntityRepository());
    validateEntity(GenericEntity);
    return (getEntityRepository().save(GenericEntity));
  }

  public Long countOfEntities()
  {
    gslLogger.info("Entry : GenericEntityServiceImpl.countOfEntities()");
    gslLogger.info("EntityRepository : " + getEntityRepository());
    return Long.valueOf(getEntityRepository().count());
  }

  public Boolean IsExists(PK entityId)
  {
    gslLogger.info("Entry : GenericEntityServiceImpl.IsExists()");
    gslLogger.info("EntityRepository : " + getEntityRepository());
    return Boolean.valueOf(getEntityRepository().exists(entityId));
  }

  public void deleteEntityById(PK entityId)
  {
    gslLogger.info("Entry : GenericEntityServiceImpl.deleteEntityById()");
    gslLogger.info("EntityRepository : " + getEntityRepository());
    getEntityRepository().delete(entityId);
  }

  public void deleteAllEntities()
  {
    gslLogger.info("Entry : GenericEntityServiceImpl.deleteAllEntities()");
    gslLogger.info("EntityRepository : " + getEntityRepository());
    getEntityRepository().deleteAll();
  }

  public Page<T> findByEntity(T entity, DRPageConfig pageInfo)
  {
    gslLogger.info("Entry : GenericEntityServiceImpl.findByEntity()");
    gslLogger.info("EntityRepository : " + getEntityRepository());
    return getEntityRepository().findByEntityForPage(entity, pageInfo);
  }

  public List<T> findByEntityCreatedBetween(T entity, Date from, Date to)
  {
    gslLogger.info("Entry : GenericEntityServiceImpl.findByEntityWithRange()");
    gslLogger.info("EntityRepository : " + getEntityRepository());
    return getEntityRepository().findByEntityCreatedBetween(entity, from, to);
  }

  public Page<T> findByEntityCreatedBetween(T entity, Date from, Date to, DRPageConfig pageInfo)
  {
    gslLogger.info("Entry : GenericEntityServiceImpl.findByEntityWithRange()");
    gslLogger.info("EntityRepository : " + getEntityRepository());
    return getEntityRepository().findByEntityCreatedBetweenForPage(entity, pageInfo, from, to);
  }

  public List<T> findAllSorted(DRPageConfig pageInfo)
  {
    gslLogger.info("Entry : GenericEntityServiceImpl.findAllSorted(DRPageConfig pageInfo)");
    gslLogger.debug("find All sorted" + pageInfo.getSortDirection());
    return getEntityRepository().findAllSorted(pageInfo);
  }
}