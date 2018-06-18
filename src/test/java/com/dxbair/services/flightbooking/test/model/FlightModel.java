package com.dxbair.services.flightbooking.test.model;

public class FlightModel {

	private String departure;
	private String arrival;
	private String departureDate;
	private String arrivalDate;

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	@Override
	public String toString() {
		return "FlightModel [departure=" + departure + ", arrival=" + arrival + ", departureDate=" + departureDate
				+ ", arrivalDate=" + arrivalDate + "]";
	}

}
