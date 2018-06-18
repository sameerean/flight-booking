package com.dxbair.services.flightbooking.flight;

import com.dxbair.services.flightbooking.system.ResourceNotFoundException;

public class FlightNotFoundException extends ResourceNotFoundException {

	private static final long serialVersionUID = 6293499259584600291L;

	public FlightNotFoundException(String flightId) {
		super("Flight", "flight-id", flightId);
	}

}
