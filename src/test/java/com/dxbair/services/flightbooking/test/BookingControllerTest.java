package com.dxbair.services.flightbooking.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.dxbair.services.flightbooking.booking.BookingController;

@RunWith(SpringRunner.class)
@WebMvcTest(BookingController.class)
public class BookingControllerTest {
	
	@Autowired
	private MockMvc mockController;
	
	@Test
	public void getBookingById() throws Exception {
		
		System.out.println("Hello...");
		
		String bookingId = "xyz12345";

		mockController.perform(MockMvcRequestBuilders.get("/" + bookingId))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("id").value(bookingId));
		
	}

}
