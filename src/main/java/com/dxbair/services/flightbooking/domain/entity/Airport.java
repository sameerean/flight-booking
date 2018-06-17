package com.dxbair.services.flightbooking.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Airport {

	@Id
	private String iataCode;
	private String name;
	private String countryIsoCode;

	public Airport() {
		super();
	}

	public Airport(String iataCode, String name, String countryIsoCode) {
		super();
		this.iataCode = iataCode;
		this.name = name;
		this.countryIsoCode = countryIsoCode;
	}

	public String getIataCode() {
		return iataCode;
	}

	public void setIataCode(String iataCode) {
		this.iataCode = iataCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountryIsoCode() {
		return countryIsoCode;
	}

	public void setCountryIsoCode(String countryIsoCode) {
		this.countryIsoCode = countryIsoCode;
	}

}
