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
 * The persistent class for the ravanna_book database table.
 * 
 */
@Entity
@Table(name="ravanna_book")
@NamedQuery(name="RavannaBook.findAll", query="SELECT r FROM RavannaBook r")
public class RavannaBook extends GenericEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String createdBy;
	private String issueMonth;
	private Long seriesEnd;
	private Long seriesStart;
	private String updatedBy;
	private Mine mine;

	public RavannaBook() {
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


	@Column(name="ISSUE_MONTH")
	public String getIssueMonth() {
		return this.issueMonth;
	}

	public void setIssueMonth(String issueMonth) {
		this.issueMonth = issueMonth;
	}


	@Column(name="SERIES_END")
	public Long getSeriesEnd() {
		return this.seriesEnd;
	}

	public void setSeriesEnd(Long seriesEnd) {
		this.seriesEnd = seriesEnd;
	}


	@Column(name="SERIES_START")
	public Long getSeriesStart() {
		return this.seriesStart;
	}

	public void setSeriesStart(Long seriesStart) {
		this.seriesStart = seriesStart;
	}


	@Column(name="UPDATED_BY")
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}


	//bi-directional many-to-one association to Mine
	@ManyToOne
	@JoinColumn(name="MINES_ID")
	public Mine getMine() {
		return this.mine;
	}

	public void setMine(Mine mine) {
		this.mine = mine;
	}

}