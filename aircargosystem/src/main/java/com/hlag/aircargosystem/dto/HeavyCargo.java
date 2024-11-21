package com.hlag.aircargosystem.dto;


public class HeavyCargo extends Cargo {

	private double loadLimit;

	public HeavyCargo(String cargoId, String description, int weight, double loadLimit) {
		super(cargoId, description, weight);
		this.loadLimit = loadLimit;
	}

	@Override
	public void displayDetails() {
		super.displayDetails();
		System.out.println("LoadLimit: " + loadLimit + " tons");
	}
}