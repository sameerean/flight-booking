package com.dxbair.services.flightbooking.passenger;

import java.util.List;

import com.dxbair.services.flightbooking.domain.entity.Passenger;

public interface PassengerService {
	
	Passenger getPassengerById(String passengerId);

	List<Passenger> getAllPassengers();
}
