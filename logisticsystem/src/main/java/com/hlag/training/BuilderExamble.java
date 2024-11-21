package com.hlag.training;

public class BuilderExamble {

	public static void main(String[] args) {
		// Building a shipment with all attributes
		Shipment shipment = new Shipment.ShipmentBuilder("New York", "Overnight", "2024-11-25")
				.withTrackingNumber("TRACK123456789")
				.withInsurance(true)
				.withGiftWrap(true)
				.build();

		System.out.println("shipment" + shipment);

		// Building another shipment with a different configuration (no insurance and gift wrap)
		Shipment shipment2 = new Shipment.ShipmentBuilder("Los Angeles", "Standard", "2024-11-28")
				.withTrackingNumber("TRACK987654321")
				.build();

		System.out.println("shipment2" + shipment2);

	}
}

class Shipment {

	private String destination;
	private String shipmentType;
	private String shippingDate;
	private String trackingNumber;
	private boolean insurance;
	private boolean giftWrap;

	@Override
	public String toString() {
		return "Shipment [destination=" + destination + ", shipmentType=" + shipmentType + ", shippingDate=" + shippingDate
				+ ", trackingNumber=" + trackingNumber + ", insurance=" + insurance + ", giftWrap=" + giftWrap + "]";
	}

	// Private constructor to enforce object creation through Builder
	private Shipment(ShipmentBuilder builder) {
		this.destination = builder.destination;
		this.shipmentType = builder.shipmentType;
		this.shippingDate = builder.shippingDate;
		this.trackingNumber = builder.trackingNumber;
		this.insurance = builder.insurance;
		this.giftWrap = builder.giftWrap;
	}

	static class ShipmentBuilder {

		private String destination;
		private String shipmentType;
		private String shippingDate;
		private String trackingNumber;
		private boolean insurance;
		private boolean giftWrap;

		// constructor with mandatory fields
		public ShipmentBuilder(String destination, String shipmentType, String shippingDate) {
			this.destination = destination;
			this.shipmentType = shipmentType;
			this.shippingDate = shippingDate;
		}

		// build method to create Shipment object,optional filelds are not mandatory
		public ShipmentBuilder withTrackingNumber(String trackingNumber) {
			this.trackingNumber = trackingNumber;
			return this;
		}

		public ShipmentBuilder withInsurance(boolean insurance) {
			this.insurance = insurance;
			return this;
		}

		public ShipmentBuilder withGiftWrap(boolean giftWrap) {
			this.giftWrap = giftWrap;
			return this;
		}

		// build method to create a final Shipment object
		public Shipment build() {
			return new Shipment(this);
		}

	}

}