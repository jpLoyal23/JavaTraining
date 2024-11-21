package com.hlag.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.hlag.dto.Product;

public class InventoryRepositoryImpl implements InventoryRepository {

	private static InventoryRepositoryImpl inventoryRepositoryImpl;

	private List<Product> products = new ArrayList<>();

	private InventoryRepositoryImpl() {
	}

	public static InventoryRepositoryImpl getInstance() {
		if (inventoryRepositoryImpl == null) {
			inventoryRepositoryImpl = new InventoryRepositoryImpl();
		}
		return inventoryRepositoryImpl;

	}

	@Override
	public Product addProduct(Product product) {
		boolean result = products.add(product);
		if (result) {
			return product;
		}
		return null;
	}

	@Override
	public Optional<Product> getProduct(String id) {
		return products.stream().filter(product -> product.getProductID().toString().equals(id)).findFirst();

	}

	@Override
	public void deleteProduct(String id) {
		Optional<Product> product = getProduct(id);
		if (product.isPresent()) {
			products.remove(product.get());
			System.out.println("Product with ID " + id + " deleted.");
		} else {
			System.out.println("Product with ID " + id + " not found.");
		}
	}

	@Override
	public Product updateProduct(String id, Product updatedProduct) {
		Optional<Product> existProduct = getProduct(id);
		if (existProduct.isPresent()) {
			Product product = existProduct.get();
			int index = products.indexOf(product);
			products.add(index, updatedProduct);
			return updatedProduct;
		}
		return updatedProduct;
	}

	@Override
	public Optional<List<Product>> getProducts() {
		if (products.isEmpty()) {
			return Optional.empty();
		} else {
			return Optional.of(new ArrayList<>(products));
		}
	}

}
