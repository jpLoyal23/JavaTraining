package com.hlag.aircargosystem.dto;

public class Cargo {

	private String cargoId;
	private String description;
	protected int weight;

	public Cargo(String cargoId, String description, int weight) {
		this.cargoId = cargoId;
		this.description = description;
		setWeight(weight);
	}

	public String getCargoId() {
		return cargoId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		if (weight > 0) {
			this.weight = weight;
		} else {
			System.out.println("Weight must be positive.");
		}
	}

	public void displayDetails() {
		System.out.println("Cargo ID: " + cargoId + ", Description: " + description + ", Weight: " + weight);
	}

	public double calculateShippingCost(double weight) {
		return weight * 2.5;
	}

	public double calculateShippingCost(double weight, double distance) {
		return weight * distance * 0.05;
	}

}
