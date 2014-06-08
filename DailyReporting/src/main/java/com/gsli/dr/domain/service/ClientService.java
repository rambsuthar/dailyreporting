package com.gsli.dr.domain.service;

import com.gsli.dr.domain.entity.Client;
import com.gsli.dr.domain.generic.GenericEntityService;
import com.gsli.dr.domain.generic.GenericRepository;

public abstract interface ClientService extends GenericEntityService<Client, Long> {

	public abstract GenericRepository<Client, Long> getEntityRepository();
}
