package com.ibm.learning.model;

public class OrderResponse {

	private String orderStatus;

	public OrderResponse(String orderStatus) {
		super();
		this.orderStatus = orderStatus;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	

}
