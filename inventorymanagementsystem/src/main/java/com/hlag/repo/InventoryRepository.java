package com.hlag.repo;

import java.util.List;
import java.util.Optional;

import com.hlag.dto.Product;

public interface InventoryRepository {

	public Product addProduct(Product product);

	public Optional<Product> getProduct(String id);

	public void deleteProduct(String id);

	public Product updateProduct(String id, Product product);

	public Optional<List<Product>> getProducts();

}
