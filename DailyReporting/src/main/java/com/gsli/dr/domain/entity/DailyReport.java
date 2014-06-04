package com.gsli.dr.domain.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.gsli.dr.domain.generic.GenericEntity;


/**
 * The persistent class for the daily_report database table.
 * 
 */
@Entity
@Table(name="daily_report")
@NamedQuery(name="DailyReport.findAll", query="SELECT d FROM DailyReport d")
public class DailyReport extends GenericEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String createdBy;
	private Date drDate;
	private Long ravannaNum;
	private Long royaltyAmount;
	private String updatedBy;
	private Long weight;
	private Client client;
	private Contractor contractor;
	private MinesProduct minesProduct;
	private Vehicle vehicle;

	public DailyReport() {
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


	@Temporal(TemporalType.DATE)
	@Column(name="DR_DATE")
	public Date getDrDate() {
		return this.drDate;
	}

	public void setDrDate(Date drDate) {
		this.drDate = drDate;
	}


	@Column(name="RAVANNA_NUM")
	public Long getRavannaNum() {
		return this.ravannaNum;
	}

	public void setRavannaNum(Long ravannaNum) {
		this.ravannaNum = ravannaNum;
	}


	@Column(name="ROYALTY_AMOUNT")
	public Long getRoyaltyAmount() {
		return this.royaltyAmount;
	}

	public void setRoyaltyAmount(Long royaltyAmount) {
		this.royaltyAmount = royaltyAmount;
	}


	@Column(name="UPDATED_BY")
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}


	public Long getWeight() {
		return this.weight;
	}

	public void setWeight(Long weight) {
		this.weight = weight;
	}


	//bi-directional many-to-one association to Client
	@ManyToOne
	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}


	//bi-directional many-to-one association to Contractor
	@ManyToOne
	public Contractor getContractor() {
		return this.contractor;
	}

	public void setContractor(Contractor contractor) {
		this.contractor = contractor;
	}


	//bi-directional many-to-one association to MinesProduct
	@ManyToOne
	@JoinColumn(name="MINES_PRODUCT_ID")
	public MinesProduct getMinesProduct() {
		return this.minesProduct;
	}

	public void setMinesProduct(MinesProduct minesProduct) {
		this.minesProduct = minesProduct;
	}


	//bi-directional many-to-one association to Vehicle
	@ManyToOne
	public Vehicle getVehicle() {
		return this.vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

}