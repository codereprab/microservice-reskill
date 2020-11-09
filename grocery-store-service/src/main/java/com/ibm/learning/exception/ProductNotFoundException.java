package com.ibm.learning.exception;

public class ProductNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1951008448950951896L;
	
	public ProductNotFoundException(String exception) {
		super(exception);
	}
}
