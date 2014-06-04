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
 * The persistent class for the user_firms database table.
 * 
 */
@Entity
@Table(name="user_firms")
@NamedQuery(name="UserFirm.findAll", query="SELECT u FROM UserFirm u")
public class UserFirm extends GenericEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String createdBy;
	private String updatedBy;
	private Firm firm;
	private ReportUser reportUser;

	public UserFirm() {
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


	@Column(name="UPDATED_BY")
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}


	//bi-directional many-to-one association to Firm
	@ManyToOne
	public Firm getFirm() {
		return this.firm;
	}

	public void setFirm(Firm firm) {
		this.firm = firm;
	}


	//bi-directional many-to-one association to ReportUser
	@ManyToOne
	@JoinColumn(name="REPORT_USER_ID")
	public ReportUser getReportUser() {
		return this.reportUser;
	}

	public void setReportUser(ReportUser reportUser) {
		this.reportUser = reportUser;
	}

}