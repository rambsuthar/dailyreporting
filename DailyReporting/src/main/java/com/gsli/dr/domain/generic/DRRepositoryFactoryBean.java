package com.gsli.dr.domain.generic;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

public class DRRepositoryFactoryBean<T extends JpaRepository<S, ID>, S, ID extends Serializable> extends JpaRepositoryFactoryBean<T, S, ID>
{
  protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager)
  {
    return new DRRepositoryFactory(entityManager);
  }

  private static class DRRepositoryFactory extends JpaRepositoryFactory {
    public DRRepositoryFactory(EntityManager entityManager) {
      super(entityManager);
    }

    protected <T, ID extends Serializable> SimpleJpaRepository<?, ?> getTargetRepository(RepositoryMetadata metadata, EntityManager entityManager)
    {
      return new GenericRepositoryImpl<>(getEntityInformation(metadata.getDomainType()), entityManager);
    }

    protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata)
    {
      return GenericRepositoryImpl.class;
    }
  }
}