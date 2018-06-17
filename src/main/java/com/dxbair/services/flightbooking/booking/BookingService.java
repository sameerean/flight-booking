package com.dxbair.services.flightbooking.booking;

import java.util.List;

import com.dxbair.services.flightbooking.domain.entity.FlightBooking;

public interface BookingService {
	
	FlightBooking getBooking(String bookingId);
	
	List<FlightBooking> getAllBookingsByPassenger(String passengerId);
	
	void createSampleBookings();

}
