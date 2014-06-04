package com.gsli.dr.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.gsli.dr.domain.generic.GenericEntity;


/**
 * The persistent class for the client_dues database table.
 * 
 */
@Entity
@Table(name="client_dues")
@NamedQuery(name="ClientDue.findAll", query="SELECT c FROM ClientDue c")
public class ClientDue extends GenericEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String createdBy;
	private Long dueAmount;
	private String status;
	private String updatedBy;
	private ClientPayment clientPayment;

	public ClientDue() {
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


	@Column(name="DUE_AMOUNT")
	public Long getDueAmount() {
		return this.dueAmount;
	}

	public void setDueAmount(Long dueAmount) {
		this.dueAmount = dueAmount;
	}


	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	@Column(name="UPDATED_BY")
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}


	//bi-directional many-to-one association to ClientPayment
	@ManyToOne
	@JoinColumn(name="LAST_PAYMENT_ID")
	public ClientPayment getClientPayment() {
		return this.clientPayment;
	}

	public void setClientPayment(ClientPayment clientPayment) {
		this.clientPayment = clientPayment;
	}

}