package com.gsli.dr.domain.service;

import com.gsli.dr.domain.entity.Vehicle;
import com.gsli.dr.domain.generic.GenericEntityService;
import com.gsli.dr.domain.generic.GenericRepository;

public abstract interface VehicleService extends GenericEntityService<Vehicle, Long> {

	public GenericRepository<Vehicle, Long> getEntityRepository() ;
	
}
