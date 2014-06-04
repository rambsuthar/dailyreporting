package com.gsli.dr.domain.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.gsli.dr.domain.generic.GenericEntity;


/**
 * The persistent class for the client_payment database table.
 * 
 */
@Entity
@Table(name="client_payment")
@NamedQuery(name="ClientPayment.findAll", query="SELECT c FROM ClientPayment c")
public class ClientPayment extends GenericEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long amount;
	private String bankName;
	private Date checkDate;
	private String createdBy;
	private Long draftNum;
	private String paymentMode;
	private String recievedFrom;
	private String updatedBy;
	private List<ClientDue> clientDues;
	private Client client;

	public ClientPayment() {
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


	@Column(name="BANK_NAME")
	public String getBankName() {
		return this.bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="CHECK_DATE")
	public Date getCheckDate() {
		return this.checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}


	@Column(name="CREATED_BY")
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	@Column(name="DRAFT_NUM")
	public Long getDraftNum() {
		return this.draftNum;
	}

	public void setDraftNum(Long draftNum) {
		this.draftNum = draftNum;
	}


	@Column(name="PAYMENT_MODE")
	public String getPaymentMode() {
		return this.paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}


	@Column(name="RECIEVED_FROM")
	public String getRecievedFrom() {
		return this.recievedFrom;
	}

	public void setRecievedFrom(String recievedFrom) {
		this.recievedFrom = recievedFrom;
	}


	@Column(name="UPDATED_BY")
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}


	//bi-directional many-to-one association to ClientDue
	@OneToMany(mappedBy="clientPayment")
	public List<ClientDue> getClientDues() {
		return this.clientDues;
	}

	public void setClientDues(List<ClientDue> clientDues) {
		this.clientDues = clientDues;
	}

	public ClientDue addClientDue(ClientDue clientDue) {
		getClientDues().add(clientDue);
		clientDue.setClientPayment(this);

		return clientDue;
	}

	public ClientDue removeClientDue(ClientDue clientDue) {
		getClientDues().remove(clientDue);
		clientDue.setClientPayment(null);

		return clientDue;
	}


	//bi-directional many-to-one association to Client
	@ManyToOne
	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}