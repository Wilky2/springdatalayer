package com.carlibassurance.datalayer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlibassurance.datalayer.model.Product;
import com.carlibassurance.datalayer.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public Iterable<Product> getProducts(){
		return this.productRepository.findAll();
	}
	
	public Optional<Product> getProduct(Integer product_id){
		return this.productRepository.findById(product_id);
	}
	
	public Product addProduct(Product product) {
		return this.productRepository.save(product);
	}
}
