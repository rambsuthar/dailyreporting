package com.gsli.dr.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import com.gsli.dr.domain.generic.GenericEntity;


/**
 * The persistent class for the formula database table.
 * 
 */
@Entity
@NamedQuery(name="Formula.findAll", query="SELECT f FROM Formula f")
public class Formula extends GenericEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String createdBy;
	private String fKey;
	private String fName;
	private String fValue;
	private String updatedBy;

	public Formula() {
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


	@Column(name="F_KEY")
	public String getFKey() {
		return this.fKey;
	}

	public void setFKey(String fKey) {
		this.fKey = fKey;
	}


	@Column(name="F_NAME")
	public String getFName() {
		return this.fName;
	}

	public void setFName(String fName) {
		this.fName = fName;
	}


	@Column(name="F_VALUE")
	public String getFValue() {
		return this.fValue;
	}

	public void setFValue(String fValue) {
		this.fValue = fValue;
	}


	@Column(name="UPDATED_BY")
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

}