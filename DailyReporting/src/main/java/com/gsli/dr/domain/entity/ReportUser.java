package com.gsli.dr.domain.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.gsli.dr.domain.generic.GenericEntity;


/**
 * The persistent class for the report_user database table.
 * 
 */
@Entity
@Table(name="report_user")
@NamedQuery(name="ReportUser.findAll", query="SELECT r FROM ReportUser r")
public class ReportUser extends GenericEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String address;
	private String createdBy;
	private Date effectiveDate;
	private String email;
	private String firstName;
	private String lastName;
	private Long phone;
	private Date terminationDate;
	private String updatedBy;
	private String userName;
	private UserLogin userLogin;
	private List<UserFirm> userFirms;
	private List<UserRole> userRoles;

	public ReportUser() {
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


	@Column(name="CREATED_BY")
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="EFFECTIVE_DATE")
	public Date getEffectiveDate() {
		return this.effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}


	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Column(name="FIRST_NAME")
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	@Column(name="LAST_NAME")
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Long getPhone() {
		return this.phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="TERMINATION_DATE")
	public Date getTerminationDate() {
		return this.terminationDate;
	}

	public void setTerminationDate(Date terminationDate) {
		this.terminationDate = terminationDate;
	}


	@Column(name="UPDATED_BY")
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}


	@Column(name="USER_NAME")
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	//bi-directional many-to-one association to UserFirm
	@OneToMany(mappedBy="reportUser")
	public List<UserFirm> getUserFirms() {
		return this.userFirms;
	}

	public void setUserFirms(List<UserFirm> userFirms) {
		this.userFirms = userFirms;
	}

	public UserFirm addUserFirm(UserFirm userFirm) {
		getUserFirms().add(userFirm);
		userFirm.setReportUser(this);

		return userFirm;
	}

	public UserFirm removeUserFirm(UserFirm userFirm) {
		getUserFirms().remove(userFirm);
		userFirm.setReportUser(null);

		return userFirm;
	}


	//bi-directional many-to-one association to UserRole
	@OneToMany(mappedBy="reportUser")
	public List<UserRole> getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public UserRole addUserRole(UserRole userRole) {
		getUserRoles().add(userRole);
		userRole.setReportUser(this);

		return userRole;
	}

	public UserRole removeUserRole(UserRole userRole) {
		getUserRoles().remove(userRole);
		userRole.setReportUser(null);

		return userRole;
	}
	
	//bi-directional many-to-one association to UserLogin
		@ManyToOne
		@JoinColumn(name="USERNAME")
		public UserLogin getUserLogin() {
			return this.userLogin;
		}

		public void setUserLogin(UserLogin userLogin) {
			this.userLogin = userLogin;
		}

}