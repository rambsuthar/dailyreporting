package com.gsli.dr.domain.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the user_login database table.
 * 
 */
@Entity
@Table(name="user_login")
@NamedQuery(name="UserLogin.findAll", query="SELECT u FROM UserLogin u")
public class UserLogin extends com.gsli.dr.domain.generic.GenericEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private String username;
	private byte enabled;
	private String password;
	private List<ReportUser> reportUsers;

	public UserLogin() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public byte getEnabled() {
		return this.enabled;
	}

	public void setEnabled(byte enabled) {
		this.enabled = enabled;
	}


	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	//bi-directional many-to-one association to ReportUser
	@OneToMany(mappedBy="userLogin")
	public List<ReportUser> getReportUsers() {
		return this.reportUsers;
	}

	public void setReportUsers(List<ReportUser> reportUsers) {
		this.reportUsers = reportUsers;
	}

	public ReportUser addReportUser(ReportUser reportUser) {
		getReportUsers().add(reportUser);
		reportUser.setUserLogin(this);

		return reportUser;
	}

	public ReportUser removeReportUser(ReportUser reportUser) {
		getReportUsers().remove(reportUser);
		reportUser.setUserLogin(null);

		return reportUser;
	}

}