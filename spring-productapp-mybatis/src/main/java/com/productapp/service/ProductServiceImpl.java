package com.productapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.Product;
import com.productapp.repository.IProductRepository;
@Service
public class ProductServiceImpl implements IProductService{

	@Autowired
	IProductRepository service;
	
	@Override
	public void addProduct(Product product) {
		service.addProduct(product);
	}

	@Override
	public void updateProduct(int productId,double price) {
		service.updateProduct(productId,price);
	}

	@Override
	public void deleteProduct(int productId) {
        service.deleteProduct(productId);		
	}

	@Override
	public Product getById(int productId) throws ProductNotFoundException {
		Product product=service.findById(productId);
		if(product==null) {
			throw new ProductNotFoundException("Product not found from this Id");
		}
		return product;
	}

	@Override
	public List<Product> getAll() {
		List<Product> products=service.findAll();
		return products;
	}

	@Override
	public List<Product> getByBrand(String brand) throws ProductNotFoundException {
		List<Product> products=service.findByBrand(brand);
		if(products.isEmpty()) {
			throw new ProductNotFoundException("Product is not found from this brand");
		}
		return products;
	}

	@Override
	public List<Product> getByLessPrice(double price) throws ProductNotFoundException {
		List<Product> products=service.findByLessPrice(price);
		if(products.isEmpty()) {
			throw new ProductNotFoundException("Product is not found from this price");
		}
		return products;
	}

	@Override
	public List<Product> getByCategortyandPrice(String category, double price) throws ProductNotFoundException {
		List<Product> products=service.findByCategortyandPrice(category, price);
		if(products.isEmpty()) {
			throw new ProductNotFoundException("Product is not found from this category and price");
		}
		return products;
	}

}
