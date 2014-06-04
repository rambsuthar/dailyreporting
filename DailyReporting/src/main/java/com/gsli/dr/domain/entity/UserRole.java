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
 * The persistent class for the user_role database table.
 * 
 */
@Entity
@Table(name="user_role")
@NamedQuery(name="UserRole.findAll", query="SELECT u FROM UserRole u")
public class UserRole extends GenericEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String createdBy;
	private String updatedBy;
	private ReportUser reportUser;
	private Role role;

	public UserRole() {
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


	//bi-directional many-to-one association to ReportUser
	@ManyToOne
	@JoinColumn(name="REPORT_USER_ID")
	public ReportUser getReportUser() {
		return this.reportUser;
	}

	public void setReportUser(ReportUser reportUser) {
		this.reportUser = reportUser;
	}


	//bi-directional many-to-one association to Role
	@ManyToOne
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}