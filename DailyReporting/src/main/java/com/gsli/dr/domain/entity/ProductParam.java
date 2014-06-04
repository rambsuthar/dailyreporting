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
 * The persistent class for the product_param database table.
 * 
 */
@Entity
@Table(name="product_param")
@NamedQuery(name="ProductParam.findAll", query="SELECT p FROM ProductParam p")
public class ProductParam extends GenericEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String createdBy;
	private String pKey;
	private String pValue;
	private String unit;
	private String updatedBy;
	private Product product;

	public ProductParam() {
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


	@Column(name="P_KEY")
	public String getPKey() {
		return this.pKey;
	}

	public void setPKey(String pKey) {
		this.pKey = pKey;
	}


	@Column(name="P_VALUE")
	public String getPValue() {
		return this.pValue;
	}

	public void setPValue(String pValue) {
		this.pValue = pValue;
	}


	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}


	@Column(name="UPDATED_BY")
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}


	//bi-directional many-to-one association to Product
	@ManyToOne
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}