package com.dxbair.services.flightbooking.booking;

import com.dxbair.services.flightbooking.system.ResourceNotFoundException;

public class BookingNotFoundException extends ResourceNotFoundException {
	
	private static final long serialVersionUID = -3880429246973279969L;

	public BookingNotFoundException(String bookingId) {
		super("Booking", "booking-id", bookingId);
	}

}
