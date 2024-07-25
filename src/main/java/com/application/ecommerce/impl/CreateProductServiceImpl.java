package com.application.ecommerce.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.application.ecommerce.entities.Category;
import com.application.ecommerce.entities.Product;
import com.application.ecommerce.repository.CreateProductRepository;
import com.application.ecommerce.service.CreateProductService;

public class CreateProductServiceImpl implements CreateProductService {
	CreateProductRepository createProductRepository;
	
	@Autowired
	public CreateProductServiceImpl(CreateProductRepository createProductRepository) {
		super();
		this.createProductRepository = createProductRepository;
	}
	
	@Override
	public Product createProduct(Product product) {
		return createProductRepository.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		return createProductRepository.save(product);
	}

	@Override
	public String deleteProduct(Long productId) {
		createProductRepository.deleteById(productId);
		return "deleted succesfully";
	}

	@Override
	public Product getProduct(Long productId) {
		return createProductRepository.findById(productId).get();
	}

	@Override
	public List<Product> getProductByCategory(Category category) {
		return createProductRepository.findByCategory(category);
	}

	@Override
	public List<Product> getAllProduct() {
		return createProductRepository.findAll();
	}

}
