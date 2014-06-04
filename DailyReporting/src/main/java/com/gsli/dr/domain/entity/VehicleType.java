package com.gsli.dr.domain.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.gsli.dr.domain.generic.GenericEntity;


/**
 * The persistent class for the vehicle_type database table.
 * 
 */
@Entity
@Table(name="vehicle_type")
@NamedQuery(name="VehicleType.findAll", query="SELECT v FROM VehicleType v")
public class VehicleType extends GenericEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String createdBy;
	private String updatedBy;
	private String vDesc;
	private String vType;
	private List<Vehicle> vehicles;

	public VehicleType() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	@Column(name="CREATED_BY")
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	@Column(name="UPDATED_BY")
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}


	@Column(name="V_DESC")
	public String getVDesc() {
		return this.vDesc;
	}

	public void setVDesc(String vDesc) {
		this.vDesc = vDesc;
	}


	@Column(name="V_TYPE")
	public String getVType() {
		return this.vType;
	}

	public void setVType(String vType) {
		this.vType = vType;
	}


	//bi-directional many-to-one association to Vehicle
	@OneToMany(mappedBy="vehicleType")
	public List<Vehicle> getVehicles() {
		return this.vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public Vehicle addVehicle(Vehicle vehicle) {
		getVehicles().add(vehicle);
		vehicle.setVehicleType(this);

		return vehicle;
	}

	public Vehicle removeVehicle(Vehicle vehicle) {
		getVehicles().remove(vehicle);
		vehicle.setVehicleType(null);

		return vehicle;
	}

}