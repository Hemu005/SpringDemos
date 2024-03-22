package com.productapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.Product;
import com.productapp.repository.IProductRepository;
import com.productapp.service.IProductService;

@RestController
@RequestMapping("/product-api/v1")
public class ProductController {

	@Autowired
	IProductService service;
	
	@PostMapping("/products")
    void addProduct(@RequestBody Product product) {
    	service.addProduct(product);
    }
	
	@PutMapping("/products")
	void updateProduct(@RequestBody Product product) {
		service.updateProduct(product.getProductId(),product.getPrice());
	}
	
	@DeleteMapping("/products/product-id/{productId}")
	void deleteProduct(@PathVariable("productId") int productId) {
		service.deleteProduct(productId);
	}
	
	@GetMapping("/products/product-id/{productId}")
	Product getById(@PathVariable("productId") int productId){
		return service.getById(productId);
	}
	
	@GetMapping("/products")
	List<Product> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/products/brand/{brand}")
	List<Product> getByBrand(@PathVariable("brand") String brand){
		return service.getByBrand(brand);
	}
	
	@GetMapping("/products/price/{price}")
	List<Product> getByLessPrice(@PathVariable("price") double price){
		return service.getByLessPrice(price);
	}
	
	@GetMapping("/products/category-price")
	List<Product> getByCategortyandPrice(@RequestParam("category")String category,
			@RequestParam("price") double price){
		return service.getByCategortyandPrice(category, price);
	}
}
