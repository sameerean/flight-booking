package com.dxbair.services.flightbooking.test;

public enum ApiUrls {
	BookingURL("/bookings/"),
	BookingsURL("/bookings?uid=");

	private String url;

	ApiUrls(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}
	
	@Override
	public String toString() {
		return this.url;
	}
}
