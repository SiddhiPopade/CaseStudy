package com.checkIn.api.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.checkIn.api.model.Booking;
import com.checkIn.api.model.CheckInRecord;
import com.checkIn.api.model.FlightSearch;
import com.checkIn.api.repository.CheckInRepository;



@RestController
@CrossOrigin(origins= {"http://localhost:4200/"})

public class CheckInController {

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private CheckInRepository checkInRepository;
	
	
	
	//to insert checkin data
	@PostMapping("/checkin")
	public CheckInRecord addCheckin(@RequestBody CheckInRecord checkInRecord)
	{
		return checkInRepository.save(checkInRecord);
	}
	
	//to display all checkin data
	@GetMapping("/checkin")
	public List<CheckInRecord> getAllcheckin()
	{
		return checkInRepository.findAll();
	}
	
	// Method to fetch data by checkin id
	@GetMapping("/checkin/{Id}")
	public ResponseEntity<CheckInRecord> getCheckInId(@PathVariable Long Id)
	{
		CheckInRecord getCheckIn = checkInRepository.getById(Id);
		return ResponseEntity.ok().body(getCheckIn);
	}
		
	//Method to fetch data by booking Id
	@GetMapping("/checkin/booking/{bookingId}")
	public List<CheckInRecord> getCheckInByBookingId(@PathVariable("bookingId") Long bookingId)
	{
		return checkInRepository.findByBookingId(bookingId);
	}
		
	//External Api call to get All booking data
	@GetMapping("/checkin/booking-MS")
	public List<Object> getBook()
	{
		String url = "http://localhost:8810/book";
		Object[] objects = restTemplate.getForObject(url, Object[].class);
		return Arrays.asList(objects);
	}
		
	//External Api call to get Particular booking id data
	@GetMapping("/checkin/booking-MS/{bookingId}")
	public Booking getBookingDetail(@PathVariable("bookingId") Long bookingId)
	{
	ResponseEntity<Booking> temp = restTemplate.getForEntity("http://localhost:8810/book/"+bookingId, Booking.class);
	Booking book = temp.getBody();
	return book;
	}
	
	//External Api call to get Particular flight id data
		@GetMapping("/checkin/flight-MS/{id}")
		public FlightSearch getFlightDetail(@PathVariable("id") Long id)
		{
		ResponseEntity<FlightSearch> temp = restTemplate.getForEntity("http://localhost:8810/search/"+id, FlightSearch.class);
		FlightSearch search = temp.getBody();
		return search;
		}
	
	
		
	
}
