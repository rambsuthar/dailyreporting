package com.gsli.dr.domain.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.gsli.dr.domain.generic.GenericEntity;


/**
 * The persistent class for the revenue_advance database table.
 * 
 */
@Entity
@Table(name="revenue_advance")
@NamedQuery(name="RevenueAdvance.findAll", query="SELECT r FROM RevenueAdvance r")
public class RevenueAdvance extends GenericEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long amount;
	private Long balance;
	private String createdBy;
	private Date paidOn;
	private String paidTo;
	private String updatedBy;

	public RevenueAdvance() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Long getAmount() {
		return this.amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}


	public Long getBalance() {
		return this.balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}


	@Column(name="CREATED_BY")
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="PAID_ON")
	public Date getPaidOn() {
		return this.paidOn;
	}

	public void setPaidOn(Date paidOn) {
		this.paidOn = paidOn;
	}


	@Column(name="PAID_TO")
	public String getPaidTo() {
		return this.paidTo;
	}

	public void setPaidTo(String paidTo) {
		this.paidTo = paidTo;
	}


	@Column(name="UPDATED_BY")
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

}