package com.gsli.dr.domain.service;

import com.gsli.dr.domain.entity.Client;
import com.gsli.dr.domain.entity.Contractor;
import com.gsli.dr.domain.generic.GenericEntityService;
import com.gsli.dr.domain.generic.GenericRepository;

public abstract interface ContractorService extends GenericEntityService<Contractor, Long>{
	public abstract GenericRepository<Contractor, Long> getEntityRepository();
	
}
