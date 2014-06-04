package com.gsli.dr.domain.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.gsli.dr.domain.generic.GenericEntity;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product extends GenericEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String creadtedBy;
	private String name;
	private String updatedBy;
	private List<MinesProduct> minesProducts;
	private List<ProductParam> productParams;

	public Product() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	@Column(name="CREADTED_BY")
	public String getCreadtedBy() {
		return this.creadtedBy;
	}

	public void setCreadtedBy(String creadtedBy) {
		this.creadtedBy = creadtedBy;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Column(name="UPDATED_BY")
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}


	//bi-directional many-to-one association to MinesProduct
	@OneToMany(mappedBy="product")
	public List<MinesProduct> getMinesProducts() {
		return this.minesProducts;
	}

	public void setMinesProducts(List<MinesProduct> minesProducts) {
		this.minesProducts = minesProducts;
	}

	public MinesProduct addMinesProduct(MinesProduct minesProduct) {
		getMinesProducts().add(minesProduct);
		minesProduct.setProduct(this);

		return minesProduct;
	}

	public MinesProduct removeMinesProduct(MinesProduct minesProduct) {
		getMinesProducts().remove(minesProduct);
		minesProduct.setProduct(null);

		return minesProduct;
	}


	//bi-directional many-to-one association to ProductParam
	@OneToMany(mappedBy="product")
	public List<ProductParam> getProductParams() {
		return this.productParams;
	}

	public void setProductParams(List<ProductParam> productParams) {
		this.productParams = productParams;
	}

	public ProductParam addProductParam(ProductParam productParam) {
		getProductParams().add(productParam);
		productParam.setProduct(this);

		return productParam;
	}

	public ProductParam removeProductParam(ProductParam productParam) {
		getProductParams().remove(productParam);
		productParam.setProduct(null);

		return productParam;
	}

}