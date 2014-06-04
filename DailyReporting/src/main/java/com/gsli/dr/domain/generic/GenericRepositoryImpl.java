package com.gsli.dr.domain.generic;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import com.gsli.dr.common.view.util.DRPageConfig;
import com.gsli.dr.common.view.util.PageSortDirection;

public class GenericRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID>
  implements GenericRepository<T, ID>
{
  private JpaEntityInformation<T, ?> entityInformation;
  private EntityManager entityManager;
  private Class<T> type;

  public GenericRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager)
  {
    super(entityInformation, entityManager);
    this.setEntityInformation(entityInformation);
    this.entityManager = entityManager;
    this.setType(entityInformation.getJavaType());
  }

  public List<T> findByEntity(T entity)
  {
    Specification<T> spec = ByEntityCriteriaHelper.byEntity(this.entityManager, entity);
    return findAll(spec);
  }

  public Page<T> findByEntityForPage(T entity, DRPageConfig pageInfo)
  {
    Specification<T> spec = ByEntityCriteriaHelper.byEntity(this.entityManager, entity);
    Pageable pageSpecification = EntityPaginationHelper.constructPageSpecification(pageInfo);
    Page<T> requestedPage = findAll(spec, pageSpecification);
    return requestedPage;
  }

  public List<T> findByEntityCreatedBetween(T entity, Date from, Date to)
  {
    DateRange range = new DateRange("createdDate", from, to);
    Specification<T> spec = ByEntityCriteriaHelper.byEntityCreatedBetween(this.entityManager, entity, range);
    return findAll(spec);
  }

  public Page<T> findByEntityCreatedBetweenForPage(T entity, DRPageConfig pageInfo, Date from, Date to)
  {
    DateRange range = new DateRange("createdDate", from, to);
    Specification<T> spec = ByEntityCriteriaHelper.byEntityCreatedBetween(this.entityManager, entity, range);
    Pageable pageSpecification = EntityPaginationHelper.constructPageSpecification(pageInfo);
    Page<T> requestedPage = findAll(spec, pageSpecification);
    return requestedPage;
  }

  public List<T> findAllSorted(DRPageConfig pageInfo)
  {
    Sort.Direction sortDirection = null;

    if (pageInfo.getSortDirection().name().equals(PageSortDirection.SORT_ASC.name()))
    {
      sortDirection = Sort.Direction.ASC;
    }
    else {
      sortDirection = Sort.Direction.DESC;
    }
    Sort sort = new Sort(sortDirection, Arrays.asList(pageInfo.getPropertiesToOrderBy()));
    return findAll(sort);
  }

  public Page<T> findAllEntityPages(Specification<T> spec, DRPageConfig pageInfo)
  {
    Pageable pageSpecification = EntityPaginationHelper.constructPageSpecification(pageInfo);
    Page<T> requestedPage = findAll(spec, pageSpecification);
    return requestedPage;
  }

public Class<T> getType() {
	return type;
}

public void setType(Class<T> type) {
	this.type = type;
}

public JpaEntityInformation<T, ?> getEntityInformation() {
	return entityInformation;
}

public void setEntityInformation(JpaEntityInformation<T, ?> entityInformation) {
	this.entityInformation = entityInformation;
}
}