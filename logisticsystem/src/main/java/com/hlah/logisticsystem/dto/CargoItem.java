package com.hlah.logisticsystem.dto;

public class CargoItem {

	private int cargoWeight;
	private String dimensions;
	private String type;

	public CargoItem(int cargoWeight, String dimensions, String type) {
		this.cargoWeight = cargoWeight;
		this.dimensions = dimensions;
		this.type = type;
	}

	public double calculateShippingCost() {
		double ratePerKg = 5.0;
		return cargoWeight * ratePerKg;
	}

	public int getWeight() {
		return cargoWeight;
	}

	public String getDimensions() {
		return dimensions;
	}

	public String getType() {
		return type;
	}
	
}