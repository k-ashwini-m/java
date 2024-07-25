package com.application.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.ecommerce.entities.Category;
import com.application.ecommerce.entities.Product;

public interface CreateProductRepository extends JpaRepository<Product, Long> {
	List<Product> findByCategory(Category category);
}
