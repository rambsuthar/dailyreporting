package com.gsli.dr.domain.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.gsli.dr.domain.generic.GenericEntity;


/**
 * The persistent class for the vehicle database table.
 * 
 */
@Entity
@NamedQuery(name="Vehicle.findAll", query="SELECT v FROM Vehicle v")
public class Vehicle extends GenericEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String createdBy;
	private String driver;
	private String regNumber;
	private String updatedBy;
	private List<DailyReport> dailyReports;
	private VehicleType vehicleType;

	public Vehicle() {
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


	public String getDriver() {
		return this.driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}


	@Column(name="REG_NUMBER")
	public String getRegNumber() {
		return this.regNumber;
	}

	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}


	@Column(name="UPDATED_BY")
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}


	//bi-directional many-to-one association to DailyReport
	@OneToMany(mappedBy="vehicle")
	public List<DailyReport> getDailyReports() {
		return this.dailyReports;
	}

	public void setDailyReports(List<DailyReport> dailyReports) {
		this.dailyReports = dailyReports;
	}

	public DailyReport addDailyReport(DailyReport dailyReport) {
		getDailyReports().add(dailyReport);
		dailyReport.setVehicle(this);

		return dailyReport;
	}

	public DailyReport removeDailyReport(DailyReport dailyReport) {
		getDailyReports().remove(dailyReport);
		dailyReport.setVehicle(null);

		return dailyReport;
	}


	//bi-directional many-to-one association to VehicleType
	@ManyToOne
	@JoinColumn(name="VEHICLE_TYPE_ID")
	public VehicleType getVehicleType() {
		return this.vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

}