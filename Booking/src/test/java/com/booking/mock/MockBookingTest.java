package com.booking.mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.booking.controller.BookingController;
import com.booking.models.Booking;
import com.booking.repository.BookingRepository;

//@WebMvcTest(value = BookingController.class)
//@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest(classes = { MockBookingTest.class })
public class MockBookingTest {
	
	@Mock
	BookingRepository bookingRepository;

	@InjectMocks
	BookingController bookingController;

	public List<Booking> myBooking;
	

	// it tests the booked data
	
	/*
	 * @Test void testPostBooking() { Booking booking = new Booking(1, "harry",
	 * "potter", "male", 2, "Economic"); // it wont return the actual data from
	 * database when(bookingRepository.save(booking)).thenReturn(booking);
	 * assertEquals(booking, bookingController.postBooking(booking)); }
	 * 
	 * 
	 * // it tests to show inserted data
	 * 
	 * @Test void testGetBooking() { List<Booking> myBooking = new
	 * ArrayList<Booking>(); myBooking.add(new Booking(1, "harry", "potter", "male",
	 * 2, "Economic")); when(bookingRepository.findAll()).thenReturn(myBooking);
	 * assertEquals(1, bookingController.getBooking().size()); }
	 */
	
	@Test
	void testUpdateBooking() {
		Booking booking = new Booking();
		booking.setFirstName("Jack");
		booking.setLastName("jill");
		booking.setGender("male");
		booking.setClasss("Economic");
		booking.setNoOfSeats(2);
		Booking bookingdb = new Booking();
		//when(bookingRepository.getBybookingId(long)5).thenReturn(bookingdb);
	}

	// it tests the deleted data
	/*@Test
	void testDeleteBooking() {
		Booking booking = new Booking(1, "harry", "potter", "male", 2, "Economic");
		bookingController.deleteBook(booking);
		verify(bookingRepository, times(1)).delete(booking);// Mocking
	}*/


}
