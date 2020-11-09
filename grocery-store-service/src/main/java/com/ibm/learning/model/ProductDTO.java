package com.ibm.learning.model;


public class ProductDTO {

	private String productName;
	private int availableQty;
	private double unitPrice;

	public ProductDTO() {
		super();
	}

	public ProductDTO(String productName, int availableQty, double unitPrice) {
		super();
		this.productName = productName;
		this.availableQty = availableQty;
		this.unitPrice = unitPrice;
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

}
