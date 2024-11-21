package com.hlah.logisticsystem.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Package {

	private final String trackingId;

	private double weight;

	private String destination;

	private String status;

	private List<String> milestones;

	public void setWeight(double weight) {
		if (weight <= 0) {
			throw new IllegalArgumentException("Weight must be positive");
		}
		this.weight = weight;
	}

	public Package(String trackingId, String destination, double weight) {
		super();
		this.trackingId = trackingId;//
		this.destination = destination;
		this.status = "In Transit"; // Initial status
		this.milestones = new ArrayList<>();
		setWeight(weight);
	}

	public Package() {
		this.trackingId = "";
	}

	private static Package pack;

	public static Package getInstance() {
		if (pack == null) {
			pack = new Package();
		}
		return pack;
	}

	public String getTrackingId() {
		return trackingId;
	}

	public String getDestination() {
		return destination;
	}

	public String getStatus() {
		return status;
	}

	public List<String> getMilestones() {
		return Collections.unmodifiableList(milestones);
	}

	public void markAsDeliverd(String status) {// always 1st value not be a null
		if (this.status.equals(status)) {
			throw new IllegalStateException("Package is Transit");
		}
		this.status = "Deliverd";
		this.milestones.add("Deliverd on" + LocalDate.now());
	}

	public double getWeight() {
		return weight;
	}

}
