package com.gsli.dr.domain.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.gsli.dr.domain.generic.GenericEntity;


/**
 * The persistent class for the mines database table.
 * 
 */
@Entity
@Table(name="mines")
@NamedQuery(name="Mine.findAll", query="SELECT m FROM Mine m")
public class Mine extends GenericEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String code;
	private String createdBy;
	private String name;
	private Date startDate;
	private String status;
	private String updatedBy;
	private List<FirmMine> firmMines;
	private List<MinesProduct> minesProducts;
	private List<RavannaBook> ravannaBooks;

	public Mine() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}


	@Column(name="CREATED_BY")
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="START_DATE")
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	@Column(name="UPDATED_BY")
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}


	//bi-directional many-to-one association to FirmMine
	@OneToMany(mappedBy="mine")
	public List<FirmMine> getFirmMines() {
		return this.firmMines;
	}

	public void setFirmMines(List<FirmMine> firmMines) {
		this.firmMines = firmMines;
	}

	public FirmMine addFirmMine(FirmMine firmMine) {
		getFirmMines().add(firmMine);
		firmMine.setMine(this);

		return firmMine;
	}

	public FirmMine removeFirmMine(FirmMine firmMine) {
		getFirmMines().remove(firmMine);
		firmMine.setMine(null);

		return firmMine;
	}


	//bi-directional many-to-one association to MinesProduct
	@OneToMany(mappedBy="mine")
	public List<MinesProduct> getMinesProducts() {
		return this.minesProducts;
	}

	public void setMinesProducts(List<MinesProduct> minesProducts) {
		this.minesProducts = minesProducts;
	}

	public MinesProduct addMinesProduct(MinesProduct minesProduct) {
		getMinesProducts().add(minesProduct);
		minesProduct.setMine(this);

		return minesProduct;
	}

	public MinesProduct removeMinesProduct(MinesProduct minesProduct) {
		getMinesProducts().remove(minesProduct);
		minesProduct.setMine(null);

		return minesProduct;
	}


	//bi-directional many-to-one association to RavannaBook
	@OneToMany(mappedBy="mine")
	public List<RavannaBook> getRavannaBooks() {
		return this.ravannaBooks;
	}

	public void setRavannaBooks(List<RavannaBook> ravannaBooks) {
		this.ravannaBooks = ravannaBooks;
	}

	public RavannaBook addRavannaBook(RavannaBook ravannaBook) {
		getRavannaBooks().add(ravannaBook);
		ravannaBook.setMine(this);

		return ravannaBook;
	}

	public RavannaBook removeRavannaBook(RavannaBook ravannaBook) {
		getRavannaBooks().remove(ravannaBook);
		ravannaBook.setMine(null);

		return ravannaBook;
	}

}