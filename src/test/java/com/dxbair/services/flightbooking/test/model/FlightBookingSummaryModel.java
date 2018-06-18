package com.dxbair.services.flightbooking.test.model;

public class FlightBookingSummaryModel {

	private String bookingId;
	private String lastName;
	private String departure;

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

	@Override
	public String toString() {
		return "FlightBookingSummaryModel [bookingId=" + bookingId + ", lastName=" + lastName + ", departure="
				+ departure + "]";
	}

}
