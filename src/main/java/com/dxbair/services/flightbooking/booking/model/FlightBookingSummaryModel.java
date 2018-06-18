package com.dxbair.services.flightbooking.booking.model;

public class FlightBookingSummaryModel {

	private String bookingId;
	private String lastName;
	private String departure;

	public FlightBookingSummaryModel() {
		super();
	}

	public FlightBookingSummaryModel(String bookingId, String lastName, String departure) {
		super();
		this.bookingId = bookingId;
		this.lastName = lastName;
		this.departure = departure;
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

}
