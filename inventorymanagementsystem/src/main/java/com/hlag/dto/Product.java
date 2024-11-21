package com.hlag.dto;

import java.util.UUID;

public class Product {

	private UUID productID;
	private String name;
	private String description;
	private Double price;
	private Long quantity;

	public Product() {

	}

	public Product(UUID productID, String name, String description, Double price, Long quantity) {
		this.productID = productID;
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}

	public UUID getProductID() {
		return productID;
	}

	public void setProductID(UUID productID) {
		this.productID = productID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

}
