package com.ibm.learning.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.learning.model.OrderRequest;
import com.ibm.learning.model.OrderResponse;
import com.ibm.learning.model.ProductDTO;
import com.ibm.learning.service.ProductsService;

@RestController
@RequestMapping(path="/orders")
public class OrdersController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ProductsService productsService;
	
	@PostMapping(path = "/placeOrder", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OrderResponse> placeOrder(@RequestBody List<OrderRequest> ordersList) {
		
		logger.info("In placeOrder method");
		
		// Verify if Products are available in DB
		List<ProductDTO> products = productsService.getAllProducts();
		if(products == null || products.isEmpty()) {
			return new ResponseEntity<OrderResponse>(new OrderResponse("Product(s) unavailable"), HttpStatus.NOT_FOUND);
		}
		//Convert to Map structure for product wise identification
		Map<String, ProductDTO> availableProducts = new HashMap<String, ProductDTO>(); 
		
		for(ProductDTO product: products) {
			availableProducts.put(product.getProductName(), product);
		}
		// Validate order information against available products and/or quantity
		boolean isValidOrder = true;
		String validationMessage = null;
		for(OrderRequest order: ordersList) {
			if(!availableProducts.containsKey(order.getProductName()) ||
					availableProducts.get(order.getProductName()).getAvailableQty() < order.getRequestedQuantity()) {
				validationMessage = "Product Name incorrect or quantity is insufficient in store";
				isValidOrder = false;
				break;
			}
		}
		if(!isValidOrder) {
			return new ResponseEntity<OrderResponse>(new OrderResponse(validationMessage), HttpStatus.EXPECTATION_FAILED);
		}
		OrderResponse response = new OrderResponse("Order successfully placed");
		return new ResponseEntity<OrderResponse>(response, HttpStatus.OK);
	}
}
