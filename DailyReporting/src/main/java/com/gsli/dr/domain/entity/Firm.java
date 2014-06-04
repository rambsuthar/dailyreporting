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
 * The persistent class for the firms database table.
 * 
 */
@Entity
@Table(name="firms")
@NamedQuery(name="Firm.findAll", query="SELECT f FROM Firm f")
public class Firm extends GenericEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String address;
	private Long contact1;
	private Long contact2;
	private Long contactOffice;
	private String createdBy;
	private String cstNo;
	private String email;
	private String firmName;
	private String manager;
	private String stNum;
	private String tinNum;
	private String updatedBy;
	private String vatNum;
	private List<FirmMine> firmMines;
	private List<SalesTax> salesTaxs;
	private List<UserFirm> userFirms;

	public Firm() {
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


	@Column(name="CONTACT_1")
	public Long getContact1() {
		return this.contact1;
	}

	public void setContact1(Long contact1) {
		this.contact1 = contact1;
	}


	@Column(name="CONTACT_2")
	public Long getContact2() {
		return this.contact2;
	}

	public void setContact2(Long contact2) {
		this.contact2 = contact2;
	}


	@Column(name="CONTACT_OFFICE")
	public Long getContactOffice() {
		return this.contactOffice;
	}

	public void setContactOffice(Long contactOffice) {
		this.contactOffice = contactOffice;
	}


	@Column(name="CREATED_BY")
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	@Column(name="CST_NO")
	public String getCstNo() {
		return this.cstNo;
	}

	public void setCstNo(String cstNo) {
		this.cstNo = cstNo;
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


	public String getManager() {
		return this.manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}


	@Column(name="ST_NUM")
	public String getStNum() {
		return this.stNum;
	}

	public void setStNum(String stNum) {
		this.stNum = stNum;
	}


	@Column(name="TIN_NUM")
	public String getTinNum() {
		return this.tinNum;
	}

	public void setTinNum(String tinNum) {
		this.tinNum = tinNum;
	}


	@Column(name="UPDATED_BY")
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}


	@Column(name="VAT_NUM")
	public String getVatNum() {
		return this.vatNum;
	}

	public void setVatNum(String vatNum) {
		this.vatNum = vatNum;
	}


	//bi-directional many-to-one association to FirmMine
	@OneToMany(mappedBy="firm")
	public List<FirmMine> getFirmMines() {
		return this.firmMines;
	}

	public void setFirmMines(List<FirmMine> firmMines) {
		this.firmMines = firmMines;
	}

	public FirmMine addFirmMine(FirmMine firmMine) {
		getFirmMines().add(firmMine);
		firmMine.setFirm(this);

		return firmMine;
	}

	public FirmMine removeFirmMine(FirmMine firmMine) {
		getFirmMines().remove(firmMine);
		firmMine.setFirm(null);

		return firmMine;
	}


	//bi-directional many-to-one association to SalesTax
	@OneToMany(mappedBy="firm")
	public List<SalesTax> getSalesTaxs() {
		return this.salesTaxs;
	}

	public void setSalesTaxs(List<SalesTax> salesTaxs) {
		this.salesTaxs = salesTaxs;
	}

	public SalesTax addSalesTax(SalesTax salesTax) {
		getSalesTaxs().add(salesTax);
		salesTax.setFirm(this);

		return salesTax;
	}

	public SalesTax removeSalesTax(SalesTax salesTax) {
		getSalesTaxs().remove(salesTax);
		salesTax.setFirm(null);

		return salesTax;
	}


	//bi-directional many-to-one association to UserFirm
	@OneToMany(mappedBy="firm")
	public List<UserFirm> getUserFirms() {
		return this.userFirms;
	}

	public void setUserFirms(List<UserFirm> userFirms) {
		this.userFirms = userFirms;
	}

	public UserFirm addUserFirm(UserFirm userFirm) {
		getUserFirms().add(userFirm);
		userFirm.setFirm(this);

		return userFirm;
	}

	public UserFirm removeUserFirm(UserFirm userFirm) {
		getUserFirms().remove(userFirm);
		userFirm.setFirm(null);

		return userFirm;
	}

}