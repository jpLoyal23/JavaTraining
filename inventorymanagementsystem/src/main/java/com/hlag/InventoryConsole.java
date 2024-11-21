package com.hlag;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.UUID;

import com.hlag.dto.Product;
import com.hlag.service.InventoryService;
import com.hlag.service.InventoryServiceImpl;

public class InventoryConsole {

	private final Scanner scanner = new Scanner(System.in);
	private InventoryService inventoryService;
	
	public InventoryConsole() {
 
	}
 
	public InventoryConsole(InventoryServiceImpl inventoryServiceImpl) {
		this.inventoryService = inventoryServiceImpl;
	}
	public void start() {
		while (true) {
			System.out.println("Inventory Management System:");
			System.out.println("1. Add Product");
			System.out.println("2. View All Products");
			System.out.println("3. View Product by ID");
			System.out.println("4. Update Product");
			System.out.println("5. Delete Product");
			System.out.println("6. Exit");
			System.out.print("Enter choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine();
 
			switch (choice) {
				case 1:
					addProduct();
					break;
				case 2:
					viewAllProducts();
					break;
				case 3:
					viewProductById();
					break;
				case 4:
					updateProduct();
					break;
				case 5:
					deleteProduct();
					break;
				case 6: {
					System.out.println("Exiting...");
					return;
				}
				default:
					System.out.println("Invalid choice. Try again.");
			}
		}
	}

	// this method excute Add Product
	private void addProduct() {
		System.out.print("Enter product name: ");
		String name = scanner.nextLine();
		System.out.print("description: ");
		String description = scanner.nextLine();
		System.out.print("price: ");
		double price = scanner.nextDouble();
		System.out.print("quantity: ");
		long quantity = scanner.nextInt();
 
		UUID id = generateUniqueProductID();
		Product product = new Product(id, name, description, price, quantity);
		inventoryService.addProduct(product);
		System.out.println("Product added successfully with ID: " + id);
	}
 
	// this method excute viewAllProducts
	private void viewAllProducts() {
		System.out.println("Sort by: 1. Name 2. Price");
		int sortChoice = scanner.nextInt();
		List<Product> products = (sortChoice == 1)
				? inventoryService.getProductsSortedByName()
				: inventoryService.getProductsSortedByPrice();
 
		products.forEach(System.out::println);
	}
 
	// this method excute viewProductById
	private void viewProductById() {
		System.out.print("Enter product ID: ");
		String productID = scanner.nextLine();
		try {
			Optional<Product> product = inventoryService.getProduct(productID);
			System.out.println(product.get());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}
 
	// this method excute updateProduct
	private void updateProduct() {
		System.out.print("Enter product ID to update: ");
		String productID = scanner.nextLine();
		try {
			Optional<Product> existingProduct2 = inventoryService.getProduct(productID);
			Product existingProduct = existingProduct2.get();
 
			System.out.print("Enter new product name (" + existingProduct.getName() + "): ");
			String name = scanner.nextLine();
			System.out.print("description (" + existingProduct.getDescription() + "): ");
			String description = scanner.nextLine();
			System.out.print("price (" + existingProduct.getPrice() + "): ");
			double price = scanner.nextDouble();
			System.out.print("quantity (" + existingProduct.getQuantity() + "): ");
			long quantity = scanner.nextInt();
			UUID uuid = UUID.fromString(productID);
			Product updatedProduct = new Product(uuid, name, description, price, quantity);
			inventoryService.updateProduct(productID, updatedProduct);
			System.out.println("Product updated successfully.");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	// this method excute deleteProduct
	private void deleteProduct() {
		System.out.print("Enter product ID to delete: ");
		String productID = scanner.nextLine();
		try {
			inventoryService.deleteProduct(productID);
			System.out.println("Product deleted successfully.");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}
 
	// Main method that initiates the Inventory System console
	public static void main(String[] args) {
		InventoryConsole console = new InventoryConsole(InventoryServiceImpl.getInstance());
		console.start();
	}
 
	// Generates a unique product ID using a UUID.
	public static UUID generateUniqueProductID() {
		return UUID.randomUUID();
	}
 
}
