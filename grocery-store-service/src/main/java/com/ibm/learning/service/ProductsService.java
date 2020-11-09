package com.ibm.learning.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.learning.entity.Product;
import com.ibm.learning.exception.ProductNotFoundException;
import com.ibm.learning.model.ProductDTO;
import com.ibm.learning.repository.ProductRepository;

@Service
public class ProductsService {

	@Autowired
	ProductRepository productRepo;
	
	public List<ProductDTO> getAllProducts() {
		
		List<Product> productsFromDB = productRepo.findAll();
		
		List<ProductDTO> productsList = new ArrayList<ProductDTO>();
		
		for(Product product: productsFromDB) {
			productsList.add(new ProductDTO(product.getProductName(), product.getAvailableQty(), product.getUnitPrice()));
		}
		return productsList;
	}
	
	public ProductDTO getByProductName(String productName) {
		
		Product product = productRepo.findByProductName(productName);
		
		if(null != product) {
			return new ProductDTO(product.getProductName(), product.getAvailableQty(), product.getUnitPrice());
		}
		else throw new ProductNotFoundException("Product not available");
	}
}
