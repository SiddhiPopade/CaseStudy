package com.flightbookingsystem.flightsearch;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.flightbookingsystem.flightsearch.model.FlightSearch;
import com.flightbookingsystem.flightsearch.repository.FlightSearchRepository;



@SpringBootTest
class FlightSearchApplicationTests {
	
	@Autowired
	FlightSearchRepository flightSearchRepository;

	@Test
	public void testReadAll() {
		List<FlightSearch> list = flightSearchRepository.findAll();
		assertThat(list).size().isPositive();
	}
	
	@Test
	 void testCreate() {
		FlightSearch flightSearch = new FlightSearch();
		flightSearch.setId(1L);
		flightSearch.setFlightName("MUM-BLR");
		
		flightSearch.setFlightDate("11-08-22");
		flightSearch.setFlightTime("9pm");
		flightSearch.setOrigin("MUM");
		flightSearch.setDestination("BLR");
		flightSearch.setBusinessClassFare(12000);
		flightSearch.setEconomyClassFare(9000);
		flightSearchRepository.save(flightSearch);
		assertNotNull(flightSearchRepository.findById(1L).get());
		
		
		
	}

	
}
