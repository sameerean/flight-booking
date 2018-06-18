package com.dxbair.services.flightbooking.passenger;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxbair.services.flightbooking.domain.entity.Passenger;
import com.dxbair.services.flightbooking.domain.repo.PassengerRepository;

@Service
@Transactional(readOnly = true)
public class PassengerServiceImpl implements PassengerService {

	@Autowired
	private PassengerRepository passengerRepo;

	@Override
	public Passenger getPassengerById(String passengerId) {
		return passengerRepo.findById(passengerId).orElseThrow(() -> new PassengerNotFoundException(passengerId));
	}

	@Override
	public List<Passenger> getAllPassengers() {
		return passengerRepo.findAll();
	}

}
