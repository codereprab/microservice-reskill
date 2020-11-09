package com.ibm.learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.learning.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	Product findByProductName(String productName);
}
