package com.gsli.dr.domain.entity;

import java.io.Serializable;
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

import com.gsli.dr.domain.generic.GenericEntity;


/**
 * The persistent class for the mines_product database table.
 * 
 */
@Entity
@Table(name="mines_product")
@NamedQuery(name="MinesProduct.findAll", query="SELECT m FROM MinesProduct m")
public class MinesProduct extends GenericEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String createdBy;
	private String updatedBy;
	private List<DailyReport> dailyReports;
	private Mine mine;
	private Product product;

	public MinesProduct() {
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


	//bi-directional many-to-one association to DailyReport
	@OneToMany(mappedBy="minesProduct")
	public List<DailyReport> getDailyReports() {
		return this.dailyReports;
	}

	public void setDailyReports(List<DailyReport> dailyReports) {
		this.dailyReports = dailyReports;
	}

	public DailyReport addDailyReport(DailyReport dailyReport) {
		getDailyReports().add(dailyReport);
		dailyReport.setMinesProduct(this);

		return dailyReport;
	}

	public DailyReport removeDailyReport(DailyReport dailyReport) {
		getDailyReports().remove(dailyReport);
		dailyReport.setMinesProduct(null);

		return dailyReport;
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


	//bi-directional many-to-one association to Product
	@ManyToOne
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}