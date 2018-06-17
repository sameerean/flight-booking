package com.dxbair.services.flightbooking;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.dxbair.services.flightbooking.booking.model.FlightBookingModelMinimal;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BookingTest {
	
	@Autowired
	private TestRestTemplate restTemplate;
	

	@Test
	public void getBookingById() {
		
		System.out.println("Hello...");
		
		String bookingId = "xyz12345";
		
		ResponseEntity<FlightBookingModelMinimal> bookingResponse = restTemplate.getForEntity(ApiUrls.BookingURL + bookingId, FlightBookingModelMinimal.class);
		
		Assertions.assertThat(bookingResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
		Assertions.assertThat(bookingResponse.getBody()).isNotNull();
//		Assertions.assertThat(bookingResponse.getBody().getId()).isEqualTo(bookingId);
//		Assertions.assertThat(component)
	}

}
