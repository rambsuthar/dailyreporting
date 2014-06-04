package com.gsli.dr.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.gsli.dr.domain.generic.GenericEntity;


/**
 * The persistent class for the sales_tax database table.
 * 
 */
@Entity
@Table(name="sales_tax")
@NamedQuery(name="SalesTax.findAll", query="SELECT s FROM SalesTax s")
public class SalesTax extends GenericEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long createdBy;
	private Long due;
	private String paidBy;
	private String sMonth;
	private Long taxAmount;
	private Long updatedBy;
	private Long yYear;
	private Firm firm;

	public SalesTax() {
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
	public Long getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}


	public Long getDue() {
		return this.due;
	}

	public void setDue(Long due) {
		this.due = due;
	}


	@Column(name="PAID_BY")
	public String getPaidBy() {
		return this.paidBy;
	}

	public void setPaidBy(String paidBy) {
		this.paidBy = paidBy;
	}


	@Column(name="S_MONTH")
	public String getSMonth() {
		return this.sMonth;
	}

	public void setSMonth(String sMonth) {
		this.sMonth = sMonth;
	}


	@Column(name="TAX_AMOUNT")
	public Long getTaxAmount() {
		return this.taxAmount;
	}

	public void setTaxAmount(Long taxAmount) {
		this.taxAmount = taxAmount;
	}


	@Column(name="UPDATED_BY")
	public Long getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}


	@Column(name="Y_YEAR")
	public Long getYYear() {
		return this.yYear;
	}

	public void setYYear(Long yYear) {
		this.yYear = yYear;
	}


	//bi-directional many-to-one association to Firm
	@ManyToOne
	public Firm getFirm() {
		return this.firm;
	}

	public void setFirm(Firm firm) {
		this.firm = firm;
	}

}