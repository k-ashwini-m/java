package com.application.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.ecommerce.entities.Category;
import com.application.ecommerce.entities.Product;
import com.application.ecommerce.service.CreateProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/admin/product")
@RequiredArgsConstructor
public class ProductController {
	
	private final CreateProductService createProductService;
	
	@Autowired
    public ProductController(CreateProductService createProductService) {
        this.createProductService = createProductService;
    }
	
	@PostMapping("/create")
	public Product createProduct(@RequestBody Product product) {
		System.out.println("product"+product);
		return createProductService.createProduct(product);
	}
	
	@PutMapping("/update")
	public Product updateProduct(@RequestBody Product product) {
		return createProductService.updateProduct(product);
	}
	
	@DeleteMapping("/delete/{productId}")
	public String deleteProduct(@PathVariable("productId") Long productId) {
		createProductService.deleteProduct(productId);
		return "Deleted Succefully";
	}
	
	@GetMapping("{productId}")
	public Product getProduct(@PathVariable("productId") Long productId) {
		return createProductService.getProduct(productId);
	}
	
	@GetMapping("{category}")
	public List<Product> getProductByCategory(Category category) {
		return createProductService.getProductByCategory(category);
	}
	
	@GetMapping()
	public List<Product> getAllProduct() {
		return createProductService.getAllProduct();
	}
	
}
