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
 * The persistent class for the client database table.
 * 
 */
@Entity
@NamedQuery(name="Client.findAll", query="SELECT c FROM Client c")
public class Client extends GenericEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String address;
	private String city;
	private String contactNum1;
	private String contactNum2;
	private String contactNum3;
	private String contactPerson;
	private String createdBy;
	private String email;
	private String firmName;
	private String firmTitle;
	private String manager;
	private String phone;
	private Long pincode;
	private String state;
	private List<ClientPayment> clientPayments;
	private List<DailyReport> dailyReports;

	public Client() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	@Column(name="CONTACT_NUM1")
	public String getContactNum1() {
		return this.contactNum1;
	}

	public void setContactNum1(String contactNum1) {
		this.contactNum1 = contactNum1;
	}


	@Column(name="CONTACT_NUM2")
	public String getContactNum2() {
		return this.contactNum2;
	}

	public void setContactNum2(String contactNum2) {
		this.contactNum2 = contactNum2;
	}


	@Column(name="CONTACT_NUM3")
	public String getContactNum3() {
		return this.contactNum3;
	}

	public void setContactNum3(String contactNum3) {
		this.contactNum3 = contactNum3;
	}


	@Column(name="CONTACT_PERSON")
	public String getContactPerson() {
		return this.contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}


	@Column(name="CREATED_BY")
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Column(name="FIRM_NAME")
	public String getFirmName() {
		return this.firmName;
	}

	public void setFirmName(String firmName) {
		this.firmName = firmName;
	}


	@Column(name="FIRM_TITLE")
	public String getFirmTitle() {
		return this.firmTitle;
	}

	public void setFirmTitle(String firmTitle) {
		this.firmTitle = firmTitle;
	}


	public String getManager() {
		return this.manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}


	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	public Long getPincode() {
		return this.pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}


	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}


	//bi-directional many-to-one association to ClientPayment
	@OneToMany(mappedBy="client")
	public List<ClientPayment> getClientPayments() {
		return this.clientPayments;
	}

	public void setClientPayments(List<ClientPayment> clientPayments) {
		this.clientPayments = clientPayments;
	}

	public ClientPayment addClientPayment(ClientPayment clientPayment) {
		getClientPayments().add(clientPayment);
		clientPayment.setClient(this);

		return clientPayment;
	}

	public ClientPayment removeClientPayment(ClientPayment clientPayment) {
		getClientPayments().remove(clientPayment);
		clientPayment.setClient(null);

		return clientPayment;
	}


	//bi-directional many-to-one association to DailyReport
	@OneToMany(mappedBy="client")
	public List<DailyReport> getDailyReports() {
		return this.dailyReports;
	}

	public void setDailyReports(List<DailyReport> dailyReports) {
		this.dailyReports = dailyReports;
	}

	public DailyReport addDailyReport(DailyReport dailyReport) {
		getDailyReports().add(dailyReport);
		dailyReport.setClient(this);

		return dailyReport;
	}

	public DailyReport removeDailyReport(DailyReport dailyReport) {
		getDailyReports().remove(dailyReport);
		dailyReport.setClient(null);

		return dailyReport;
	}

}