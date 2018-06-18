package com.dxbair.services.flightbooking.boot;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Function;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.dxbair.services.flightbooking.booking.BookingService;
import com.dxbair.services.flightbooking.domain.entity.Airport;
import com.dxbair.services.flightbooking.domain.entity.Flight;
import com.dxbair.services.flightbooking.domain.entity.Passenger;
import com.dxbair.services.flightbooking.domain.repo.AirportRepository;
import com.dxbair.services.flightbooking.domain.repo.FlightRepository;
import com.dxbair.services.flightbooking.domain.repo.PassengerRepository;
import com.dxbair.services.flightbooking.domain.util.DateUtil;

@Component
@Transactional
public class DataLoader {
	private static final Logger logger = LoggerFactory.getLogger(DataLoader.class);
	private static final String passengersFile = "/data/passengers.csv";
	private static final String airportsFile = "/data/airports_with_iata_code.csv";
	private static final String flightsFile = "/data/flights.csv";

	@Autowired
	private ResourceLoader resourceLoader;

	@Autowired
	private BookingService bookingService;

	@Bean
	@Order(1)
	CommandLineRunner loadPassengers(PassengerRepository passengerRepo) {
		return (args) -> {
			loadFromCsv(resourceLoader, passengersFile, v -> new Passenger(null, v[0], v[1], v[2]), passengerRepo);
		};
	}

	@Bean
	@Order(2)
	CommandLineRunner loadAirports(AirportRepository airoprtRepo) {
		return (args) -> {
			loadFromCsv(resourceLoader, airportsFile, v -> new Airport(v[3], v[0], v[2]), airoprtRepo);
		};
	}

	@Bean
	@Order(3)
	CommandLineRunner loadFlights(FlightRepository flightRepo) {
		return (args) -> {
			loadFromCsv(resourceLoader, flightsFile,
					v -> new Flight(null, v[0], v[1], DateUtil.toLocalDateTime(v[2]), DateUtil.toLocalDateTime(v[3])),
					flightRepo);
		};
	}

	@Bean
	@Order(10)
	public CommandLineRunner bookingGenerator() {
		return (args) -> {
			bookingService.createSampleBookings();
		};
	}

	public static void loadFromCsv(ResourceLoader resourceLoader, String sourceCsvFile,
			Function<String[], Object> objectMapper, CrudRepository repo) {
		logger.debug("++++++++++++++ Loading " + sourceCsvFile + " ..........");

		Resource resource = resourceLoader.getResource("classpath:" + sourceCsvFile);

		try (Stream<String> stream = Files.lines(Paths.get(resource.getFile().getAbsolutePath()))) {
			stream.forEach(line -> {
				logger.debug("++++++++++++++" + line);
				try {
					String[] values = line.split(",");
					Object entity = objectMapper.apply(values);
					repo.save(entity);
				} catch (Exception e) {
					e.printStackTrace();
				}
			});

		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.debug("++++++++++++++ Loading " + sourceCsvFile + " DONE !");

	}

}
