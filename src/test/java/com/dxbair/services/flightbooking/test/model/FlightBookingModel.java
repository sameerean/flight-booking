package com.dxbair.services.flightbooking.test.model;

import java.util.List;

public class FlightBookingModel {

	private String id;
	private PassengerModel passenger;
	private List<FlightModel> flights;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public PassengerModel getPassenger() {
		return passenger;
	}

	public void setPassenger(PassengerModel passenger) {
		this.passenger = passenger;
	}

	public List<FlightModel> getFlights() {
		return flights;
	}

	public void setFlights(List<FlightModel> flights) {
		this.flights = flights;
	}

	@Override
	public String toString() {
		return "FlightBookingModel [id=" + id + ", passenger=" + passenger + ", flights=" + flights + "]";
	}

}
