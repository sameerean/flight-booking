package com.dxbair.services.flightbooking.booking.model.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.dxbair.services.flightbooking.booking.model.FlightBookingModelMinimal;
import com.dxbair.services.flightbooking.domain.entity.Flight;
import com.dxbair.services.flightbooking.domain.entity.FlightBooking;

@Component
public class ToFlightBookingModelMinimalConverter implements Converter<FlightBooking, FlightBookingModelMinimal> {

	@Override
	public FlightBookingModelMinimal convert(FlightBooking source) {
		Flight flight = CollectionUtils.isEmpty(source.getFlights()) ? new Flight()
				: (Flight) source.getFlights().toArray()[0];
		return new FlightBookingModelMinimal(source.getId(), source.getPassenger().getLastName(),
				flight.getDeparture());
	}

}
