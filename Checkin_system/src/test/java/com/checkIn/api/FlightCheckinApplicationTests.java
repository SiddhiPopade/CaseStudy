package com.checkIn.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.checkIn.api.model.CheckInRecord;
import com.checkIn.api.repository.CheckInRepository;

@SpringBootTest
class FlightCheckinApplicationTests {

	@Autowired
	CheckInRepository cRepo;
	
	//to insert record
	@Test
	public void testcreateCheckin()
	{
		CheckInRecord c= new CheckInRecord ();
		c.setId(1L);
		c.setLastname("Jagdale");
		c.setFirstname("Pranita");
		c.setBookingId(2);
		cRepo.save(c);
		assertNotNull(cRepo.findById(1L).get());
		
	}

	//to read all records from database
	@Test
	public void testgetAllCheckin()
	{
		List<CheckInRecord> list = cRepo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

}
