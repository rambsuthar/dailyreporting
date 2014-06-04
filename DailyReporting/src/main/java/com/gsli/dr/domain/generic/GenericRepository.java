package com.gsli.dr.domain.generic;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.gsli.dr.common.view.util.DRPageConfig;

@NoRepositoryBean
public abstract interface GenericRepository<T, ID extends Serializable> extends JpaRepository<T, ID>
{
  public abstract List<T> findByEntity(T paramT);

  public abstract Page<T> findByEntityForPage(T paramT, DRPageConfig paramDRPageConfig);

  public abstract List<T> findByEntityCreatedBetween(T paramT, Date paramDate1, Date paramDate2);

  public abstract Page<T> findByEntityCreatedBetweenForPage(T paramT, DRPageConfig paramDRPageConfig, Date paramDate1, Date paramDate2);

  public abstract List<T> findAllSorted(DRPageConfig paramDRPageConfig);

  public abstract Page<T> findAllEntityPages(Specification<T> paramSpecification, DRPageConfig paramDRPageConfig);
}
