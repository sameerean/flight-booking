package com.dxbair.services.flightbooking.passenger;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dxbair.services.flightbooking.domain.entity.Passenger;

@RestController
@RequestMapping("passengers")
public class PassengerController {

	@Autowired
	private PassengerService passengerService;

	private static final Logger logger = LoggerFactory.getLogger(PassengerController.class);

	@GetMapping
	public @ResponseBody List<Passenger> getAllPassengers() {
		return passengerService.getAllPassengers();
	}

	@GetMapping("/{passenger-id}")
	public @ResponseBody Passenger getPassengerById(@PathVariable("passenger-id") String passengerId) {
		return passengerService.getPassengerById(passengerId);
	}
}
