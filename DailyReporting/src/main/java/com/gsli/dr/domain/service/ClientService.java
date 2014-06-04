package com.gsli.dr.domain.service;

import com.gsli.dr.domain.entity.Client;
import com.gsli.dr.domain.generic.GenericRepository;

public abstract interface ClientService {

	public abstract GenericRepository<Client, Long> getEntityRepository();
}
