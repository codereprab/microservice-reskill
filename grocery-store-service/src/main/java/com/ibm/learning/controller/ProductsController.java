package com.ibm.learning.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.learning.model.ProductDTO;
import com.ibm.learning.service.ProductsService;

@RestController
@RequestMapping(path="/products")
public class ProductsController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ProductsService productsService;
	
	
	@GetMapping(path = "/getAllProducts", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductDTO>> getAllProducts() {
		
		logger.info("In getAllProducts method:");
		List<ProductDTO> products = productsService.getAllProducts();
		
		return new ResponseEntity<List<ProductDTO>>(products, HttpStatus.OK);
	}
}
