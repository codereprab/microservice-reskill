package com.ibm.learning.model;

public class OrderRequest {

	private String productName;
	private int requestedQuantity;

	public OrderRequest() {
		super();
	}
	
	public OrderRequest(String productName, int requestedQuantity) {
		super();
		this.productName = productName;
		this.requestedQuantity = requestedQuantity;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getRequestedQuantity() {
		return requestedQuantity;
	}

	public void setRequestedQuantity(int requestedQuantity) {
		this.requestedQuantity = requestedQuantity;
	}
	
	
}
