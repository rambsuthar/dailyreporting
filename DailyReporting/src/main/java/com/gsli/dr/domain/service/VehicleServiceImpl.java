package com.gsli.dr.domain.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.gsli.dr.domain.entity.Vehicle;
import com.gsli.dr.domain.generic.GenericEntityServiceImpl;
import com.gsli.dr.domain.generic.GenericRepository;
import com.gsli.dr.domain.repository.VehicleRepository;

public class VehicleServiceImpl extends GenericEntityServiceImpl<Vehicle, Long> implements VehicleService{

	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Override
	public GenericRepository<Vehicle, Long> getEntityRepository() {
		return getVehicleRepository();
	}

	@Override
	public boolean validateEntity(Vehicle paramT) {
		return true;
	}

	public VehicleRepository getVehicleRepository() {
		return vehicleRepository;
	}

	public void setVehicleRepository(VehicleRepository vehicleRepository) {
		this.vehicleRepository = vehicleRepository;
	}

}
