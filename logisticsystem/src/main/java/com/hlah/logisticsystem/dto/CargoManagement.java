package com.hlah.logisticsystem.dto;

import java.util.ArrayList;

public class CargoManagement {
	private ArrayList<CargoItem> cargoList = new ArrayList<>();

	public void addCargo(CargoItem cargo) {
		cargoList.add(cargo);
	}

	public void removeCargo(CargoItem cargo) {
		cargoList.remove(cargo);
	}

	public void displayAllCargo() {
		for (CargoItem cargo : cargoList) {
			System.out.println(cargo);
		}
	}
}
