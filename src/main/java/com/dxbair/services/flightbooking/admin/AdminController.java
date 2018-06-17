package com.dxbair.services.flightbooking.admin;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dxbair.services.flightbooking.domain.entity.Airport;
import com.dxbair.services.flightbooking.domain.entity.Flight;
import com.dxbair.services.flightbooking.domain.entity.FlightBooking;
import com.dxbair.services.flightbooking.domain.entity.Passenger;
import com.dxbair.services.flightbooking.domain.repo.AirportRepository;
import com.dxbair.services.flightbooking.domain.repo.FlightBookingRepository;
import com.dxbair.services.flightbooking.domain.repo.FlightRepository;
import com.dxbair.services.flightbooking.domain.repo.PassengerRepository;

@RestController
@RequestMapping("admin")
public class AdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private PassengerRepository passengerRepo;
	
	@Autowired
	private AirportRepository airportRepo;
	
	@Autowired
	private FlightRepository flightRepo;
	
	@Autowired
	private FlightBookingRepository bookingRepo;

	
	@GetMapping("/passengers")
	public @ResponseBody List<Passenger> getAllPassengers() {
		return passengerRepo.findAll();
	}
	
	@GetMapping("/airports")
	public @ResponseBody List<Airport> getAllAirports() {
		return airportRepo.findAll();
	}
	
	@GetMapping("/flights")
	public @ResponseBody List<Flight> getAllFlights() {
		return flightRepo.findAll();
	}
	
	@GetMapping("/booking")
	public @ResponseBody List<FlightBooking> getAllFlightBookings() {
		return bookingRepo.findAll();
	}

}
