package com.hlag.service;

import java.util.List;
import java.util.Optional;

import com.hlag.dto.Product;

public interface InventoryService {

	public Product addProduct(Product product);

	public Optional<Product> getProduct(String id);

	public void deleteProduct(String id);

	public Product updateProduct(String id, Product product);

	public List<Product> getProductsSortedByName();

	public List<Product> getProductsSortedByPrice();

	public Optional<List<Product>> getProducts();

}
