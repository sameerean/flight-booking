package com.dxbair.services.flightbooking.booking.model.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.dxbair.services.flightbooking.booking.model.FlightBookingSummaryModel;
import com.dxbair.services.flightbooking.domain.entity.Flight;
import com.dxbair.services.flightbooking.domain.entity.FlightBooking;

@Component
public class ToFlightBookingModelMinimalConverter implements Converter<FlightBooking, FlightBookingSummaryModel> {

	@Override
	public FlightBookingSummaryModel convert(FlightBooking source) {
		Flight flight = CollectionUtils.isEmpty(source.getFlights()) ? new Flight()
				: (Flight) source.getFlights().toArray()[0];
		return new FlightBookingSummaryModel(source.getId(), source.getPassenger().getLastName(),
				flight.getDeparture());
	}

}
