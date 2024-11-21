package com.hlag.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.hlag.dto.Product;
import com.hlag.repo.InventoryRepository;
import com.hlag.repo.InventoryRepositoryImpl;

public class InventoryServiceImpl implements InventoryService {

	private InventoryRepository inventoryRepository = InventoryRepositoryImpl.getInstance();
	private static InventoryServiceImpl inventoryServiceImpl;

	private InventoryServiceImpl() {
	}

	public static InventoryServiceImpl getInstance() {
		if (inventoryServiceImpl == null) {
			inventoryServiceImpl = new InventoryServiceImpl();
		}
		return inventoryServiceImpl;
	}

	@Override
	public Product addProduct(Product product) {
		return inventoryRepository.addProduct(product);
	}

	@Override
	public Optional<Product> getProduct(String id) {
		return inventoryRepository.getProduct(id);
	}

	@Override
	public void deleteProduct(String id) {
		inventoryRepository.deleteProduct(id);
	}

	@Override
	public Product updateProduct(String id, Product product) {
		return inventoryRepository.updateProduct(id, product);
	}

	@Override
	public Optional<List<Product>> getProducts() {
		return inventoryRepository.getProducts();
	}

	@Override
	public List<Product> getProductsSortedByName() {
		List<Product> products = inventoryRepository.getProducts().get();
		products.sort(Comparator.comparing(Product::getName));
		return products;
	}

	@Override
	public List<Product> getProductsSortedByPrice() {
		List<Product> products = inventoryRepository.getProducts().get();
		products.sort(Comparator.comparingDouble(Product::getPrice));
		return products;
	}
}
