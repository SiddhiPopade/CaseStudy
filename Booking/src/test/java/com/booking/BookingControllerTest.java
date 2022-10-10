package com.booking;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.booking.models.Booking;
import com.booking.repository.BookingRepository;

@SpringBootTest
class BookingControllerTest {
	
	@Autowired
	BookingRepository bookingRepository;

	

	@Order(1)
	@Test
	void testPostBooking() {
		//Check Details in Database
		Booking booking = new Booking();
		booking.setBookingId(1l);
		booking.setFirstName("Harry");
		booking.setLastName("Potter");
		booking.setClasss("Economic");
		booking.setGender("Male");
		booking.setNoOfSeats(2);
		bookingRepository.save(booking);
		assertNotNull(bookingRepository.findById(1l).get());
	}
	//to fetch data that is inserted
	@Order(2)
	@Test
	void testGetBooking() {
		List<Booking> list = bookingRepository.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	

}
