package com.hlag.aircargosystem.dto;


public class PerishableCargo extends Cargo {

	private String expirationDate;

	public PerishableCargo(String cargoId, String description, int weight, String expirationDate) {
      super(cargoId, description, weight);
      this.expirationDate = expirationDate;
  }

  @Override
  public void displayDetails() {
      super.displayDetails();
      System.out.println("Expiration Date: " + expirationDate);
  }
}
