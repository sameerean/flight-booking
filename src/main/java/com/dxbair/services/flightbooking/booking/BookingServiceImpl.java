package com.dxbair.services.flightbooking.booking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.dxbair.services.flightbooking.domain.entity.Flight;
import com.dxbair.services.flightbooking.domain.entity.FlightBooking;
import com.dxbair.services.flightbooking.domain.entity.Passenger;
import com.dxbair.services.flightbooking.domain.repo.FlightBookingRepository;
import com.dxbair.services.flightbooking.domain.repo.FlightRepository;
import com.dxbair.services.flightbooking.domain.repo.PassengerRepository;

@Service
@Transactional(readOnly = true)
public class BookingServiceImpl implements BookingService {
	private static final Logger logger = LoggerFactory.getLogger(BookingServiceImpl.class);

	@Autowired
	private FlightBookingRepository bookingRepo;

	@Autowired
	private PassengerRepository passengerRepo;

	@Autowired
	private FlightRepository flightRepo;

	@Override
	public FlightBooking getBooking(String bookingId) {
		return bookingRepo.findById(bookingId).orElseThrow(() -> new BookingNotFoundException(bookingId));
	}

	@Override
	public List<FlightBooking> getAllBookingsByPassenger(String passengerId) {
		List<FlightBooking> bookings = bookingRepo.findByPassengerId(passengerId);
		if (CollectionUtils.isEmpty(bookings))
			throw new BookingNotFoundForPassengerException(passengerId);
		return bookings;
	}

	@Override
	@Transactional
	public void createSampleBookings() {
		List<Passenger> allPassengers = passengerRepo.findAll();
		// Stream<Passenger> allPassengers =
		// passengerRepo.findAllByFirstName("Archie").stream();
		// Stream<Passenger> allPassengers = passengerRepo.streamAll();

		// allPassengers.forEach(System.out::println);

		// List<Flight> allFlights = flightRepo.findAll();
		// allFlights.stream().

		final Random flightSelector = new Random(1);

		int[] passCounter = new int[1];

		allPassengers.stream().forEach(passenger -> {

			createRandomBooking(passenger, flightSelector);

			if (passCounter[0] % 3 == 0) {
				createRandomBooking(passenger, flightSelector);
			}

			passCounter[0]++;
		});
	}

	private void createRandomBooking(Passenger passenger, Random flightSelector) {
		String flightID = "FL-" + (flightSelector.nextInt(19) + 1);
		logger.debug(">>>>>>>>>>>>>>> FL-ID = " + flightID);
		Flight flight = flightRepo.findById(flightID).orElse(null);
		logger.debug(">>>>>>>>>>>>>>>>>> Flight = " + flight);

		List<Flight> nextFlights = flightRepo.findByDepartureAndDepartureDateGreaterThan(flight.getArrival(),
				flight.getArrivalDate());
		Flight nextFlight = CollectionUtils.isEmpty(nextFlights) ? null : nextFlights.get(0);
		logger.debug(" CCCCCCCCCCCC >>>>>>>>>>>>>>>>>> nextFlight = " + nextFlight);

		FlightBooking booking = new FlightBooking();
		booking.setPassenger(passenger);

		Set<Flight> flights = new HashSet<>(2);
		flights.add(flight);
		if (CollectionUtils.isEmpty(flight.getBookings())) {
			flight.setBookings(new HashSet<>(2));
		}
		flight.getBookings().add(booking);
		if (nextFlight != null) {
			flights.add(nextFlight);
			if (CollectionUtils.isEmpty(nextFlight.getBookings())) {
				nextFlight.setBookings(new HashSet<>(2));
			}
			nextFlight.getBookings().add(booking);
		}
		booking.setFlights(flights);
		bookingRepo.save(booking);
		flightRepo.save(flight);

		flightRepo.save(flight);
		if (nextFlight != null) {
			flightRepo.save(nextFlight);
		}
	}

	@Override
	public List<FlightBooking> getAllMultiFlightBookingsByPassenger(String passengerId) {
		List<FlightBooking> bookings = bookingRepo.findByPassengerId(passengerId);
		return bookings.stream().filter(booking -> booking.getFlights().size() > 1).collect(Collectors.toList());

		/*
		final List<FlightBooking> filteredList = new ArrayList<>();
		if (CollectionUtils.isEmpty(bookings))
			return Collections.EMPTY_LIST;
		
		bookings.stream().forEach(booking -> {
			if(booking.getFlights().size() > 1) {
				filteredList.add(booking);
			}
		});
		
		return filteredList;
*/	}

	@Override
	public List<FlightBooking> getAllMultiFlightBookings() {
		List<FlightBooking> bookings = bookingRepo.findAll();
		
		/*if (CollectionUtils.isEmpty(bookings))
			return Collections.EMPTY_LIST;
		
		bookings.stream().forEach(action);*/
		return bookings;
	}

}
