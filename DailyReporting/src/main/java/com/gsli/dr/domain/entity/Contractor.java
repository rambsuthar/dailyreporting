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

import com.gsli.dr.domain.generic.GenericEntity;


/**
 * The persistent class for the contractor database table.
 * 
 */
@Entity
@NamedQuery(name="Contractor.findAll", query="SELECT c FROM Contractor c")
public class Contractor extends GenericEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String createdBy;
	private String name;
	private String phone;
	private String updatedBy;
	private List<DailyReport> dailyReports;

	public Contractor() {
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


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	@Column(name="UPDATED_BY")
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}


	//bi-directional many-to-one association to DailyReport
	@OneToMany(mappedBy="contractor")
	public List<DailyReport> getDailyReports() {
		return this.dailyReports;
	}

	public void setDailyReports(List<DailyReport> dailyReports) {
		this.dailyReports = dailyReports;
	}

	public DailyReport addDailyReport(DailyReport dailyReport) {
		getDailyReports().add(dailyReport);
		dailyReport.setContractor(this);

		return dailyReport;
	}

	public DailyReport removeDailyReport(DailyReport dailyReport) {
		getDailyReports().remove(dailyReport);
		dailyReport.setContractor(null);

		return dailyReport;
	}

}