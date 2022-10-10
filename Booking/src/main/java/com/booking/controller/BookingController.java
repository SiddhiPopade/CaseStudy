package com.booking.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.booking.entity.User;
import com.booking.models.Booking;
import com.booking.models.FlightSearch;
import com.booking.repository.BookingRepository;
//import com.booking.repository.FlightRepository;
import com.booking.repository.UserRepository;

@CrossOrigin(origins = { "http://localhost:4200/" })
@RestController
public class BookingController {

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	UserRepository userRepository;

	

	// Method to add data
	@PostMapping("/book")
	public Booking postBooking(@RequestBody Booking book) {
		return bookingRepository.save(book);
	}

	// Method to add user
	@PostMapping("/book/user")
	public User postUser(@RequestBody User user) {
		return userRepository.save(user);
	}

	// Method to fetch the inserted data
	@GetMapping("/book")
	public List<Booking> getBooking() {
		return bookingRepository.findAll();
	}


	// Method to fetch booking data of specific id
	@GetMapping("/book/{id}")
	public Optional<Booking> getBookingById(@PathVariable("id") long id) {
		return bookingRepository.findById(id);
	}

	
	@GetMapping("/book/flight/{fid}")
	public Optional<Booking> getBookingByFlightId(@PathVariable("fid") long fid) {
		return bookingRepository.findByFlightId(fid);
	}
	
	// Method to fetch booking data of specific class
	@GetMapping("/book/class/{classs}")
	public List<Booking> getBookingByClasss(@PathVariable("classs") String classs) {
		return bookingRepository.getBookingByClasss(classs);
	}

	// Method to update data
	@PutMapping("/book/{id}")
	public Booking updateBook(@PathVariable long id, @RequestBody Booking booking) {
		Booking bookingdb = bookingRepository.getById(id);
		bookingdb.setFirstName(booking.getFirstName());
		bookingdb.setLastName(booking.getLastName());
		bookingdb.setGender(booking.getGender());
		bookingdb.setClasss(booking.getClasss());
		bookingdb.setNoOfSeats(booking.getNoOfSeats());
		return bookingRepository.save(bookingdb);
	}

	// Method to delete the data
	@DeleteMapping("/book/{id}")
	public String deleteBook(@PathVariable long id) {
		bookingRepository.deleteById(id);
		return "Deleted Succesfully";
	}

	@Autowired
	private RestTemplate restTemplate;

	/*// Method to call external api
	@GetMapping("/flight")
	public List<Object> getFlight() {
		String url = "http://localhost:8081/search";
		Object[] objects = restTemplate.getForObject(url, Object[].class);
		// flightRepository.save(objects);
		return Arrays.asList(objects);

	}
	

	/*
	 * @GetMapping("/flight/{fid}") public FlightSearch
	 * getFlightDetail(@PathVariable("fid") Long fid) { ResponseEntity<FlightSearch>
	 * temp = restTemplate.getForEntity("http://localhost:8081/search"+fid,
	 * FlightSearch); FlightSearch flight = temp.getBody(); return flight; }
	 */
	
	// External Api call to get All flight data
		@GetMapping("/book/flightapi")
		public List<Object> getBook() {
			String url = "http://localhost:8810/search";
			Object[] objects = restTemplate.getForObject(url, Object[].class);
			return Arrays.asList(objects);
		}

		// External Api call to get Particular booking id data
		@GetMapping("/book/flightapi/{id}")
		public FlightSearch getBookingDetail(@PathVariable("id") Long id) {
			ResponseEntity<FlightSearch> temp = restTemplate.getForEntity("http://localhost:8810/search/" + id,
					FlightSearch.class);
			FlightSearch book = temp.getBody();
			return book;
		}
}
