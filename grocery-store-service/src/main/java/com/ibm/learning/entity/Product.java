package com.ibm.learning.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Product")
public class Product {

	@Id
	@Column
	private int productId;
	@Column
	private String productName;
	@Column
	private int availableQty;
	@Column
	private double unitPrice;

	public Product() {
		super();
	}

	public Product(int productId, String productName, int availableQty, double unitPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.availableQty = availableQty;
		this.unitPrice = unitPrice;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getAvailableQty() {
		return availableQty;
	}

	public void setAvailableQty(int availableQty) {
		this.availableQty = availableQty;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", availableQty=" + availableQty
				+ ", unitPrice=" + unitPrice + "]";
	}

}
