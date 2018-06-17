package com.dxbair.services.flightbooking.domain.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.dxbair.services.flightbooking.domain.entity.Airport;

@Transactional
public interface AirportRepository extends JpaRepository<Airport, String> {
	
}
