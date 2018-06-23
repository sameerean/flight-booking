package com.dxbair.services.flightbooking.booking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dxbair.services.flightbooking.booking.model.FlightBookingModel;
import com.dxbair.services.flightbooking.booking.model.FlightBookingSummaryModel;
import com.dxbair.services.flightbooking.booking.model.converter.ToFlightBookingModelConverter;
import com.dxbair.services.flightbooking.domain.entity.Flight;
import com.dxbair.services.flightbooking.domain.entity.FlightBooking;

@RestController
@RequestMapping("bookings")
public class BookingController {

	private static final Logger logger = LoggerFactory.getLogger(BookingController.class);

	@Autowired
	private BookingService bookingService;

	@Autowired
	private ToFlightBookingModelConverter toBookingModelConverter;

	@GetMapping("/{bookingId}")
	public @ResponseBody FlightBookingModel getBookingById(@PathVariable String bookingId) {

		logger.info("Finding booking by id ... " + bookingId);
		return toBookingModelConverter.convert(bookingService.getBooking(bookingId));
	}

	@GetMapping
	public @ResponseBody List<FlightBookingSummaryModel> getBookings(
			@RequestParam(required = false, name = "uid") String passengerId, @RequestParam(required = false, name = "multi-flights", defaultValue = "false") boolean multiFlights) {

		logger.info("Finding booking by passengerId ... " + passengerId);

		List<FlightBooking> bookings = null;
		/*
		if(multiFlights) {
			if(!StringUtils.isEmpty(passengerId)) {
				
			} else {
				
			}
		}
*/
		if(!StringUtils.isEmpty(passengerId)) {
			
			if(multiFlights) {
				bookings = bookingService.getAllMultiFlightBookingsByPassenger(passengerId);
			} else {
				bookings = bookingService.getAllBookingsByPassenger(passengerId);
			}
		} else {
			throw new BookingNotFoundException(null);
		}
		
//		List<FlightBooking> bookings = bookingService.getAllBookingsByPassenger(passengerId);
		
		
		
		List<FlightBookingSummaryModel> bookingModels = new ArrayList<>(bookings.size());
		bookings.stream().forEach(booking -> {
			bookingModels.add(new FlightBookingSummaryModel(booking.getId(), booking.getPassenger().getLastName(),
					((Flight) booking.getFlights().toArray()[0]).getDeparture()));
		});
		return bookingModels;
	}

	private List<FlightBookingSummaryModel> getBookingsByPassengerId(String passengerId) {

		logger.info("Finding booking by passengerId ... " + passengerId);

		List<FlightBooking> bookings = bookingService.getAllBookingsByPassenger(passengerId);
		List<FlightBookingSummaryModel> bookingModels = new ArrayList<>(bookings.size());
		bookings.stream().forEach(booking -> {
			bookingModels.add(new FlightBookingSummaryModel(booking.getId(), booking.getPassenger().getLastName(),
					((Flight) booking.getFlights().toArray()[0]).getDeparture()));
		});
		return bookingModels;
	}
	
	

	/*
	@GetMapping
	public @ResponseBody List<FlightBookingSummaryModel> getMultiFlightBookings(
			@RequestParam("multi-flights") boolean multiFlights) {
		
		logger.info("Finding booking with multiple flights ... " + multiFlights);
		
		return Collections.EMPTY_LIST;
		
		
	}
*/
}
