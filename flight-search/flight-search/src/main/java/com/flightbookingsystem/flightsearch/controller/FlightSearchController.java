package com.flightbookingsystem.flightsearch.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightbookingsystem.flightsearch.entity.User;
import com.flightbookingsystem.flightsearch.model.FlightSearch;
import com.flightbookingsystem.flightsearch.repository.FlightSearchRepository;
import com.flightbookingsystem.flightsearch.repository.UserRepository;

import io.swagger.annotations.ApiOperation;

//allows the server to indicate any origin other than its own
@CrossOrigin(origins = { "http://localhost:4200/" })
@RestController

public class FlightSearchController {
	
	@Autowired
	FlightSearchRepository flightSearchRepository;
	
	@Autowired
	UserRepository userRepository;

	
	// Method to add user
		@PostMapping("/search/user")
		public User postUser(@RequestBody User user) {
			return userRepository.save(user);
		}

	// add flights
	@PostMapping("/search")
	@ApiOperation(value="add flights",response=FlightSearch.class)
	public FlightSearch postFlightSearch(@RequestBody FlightSearch flightsearch) {
		return flightSearchRepository.save(flightsearch);
	}
	
	//method to get all flights
	@GetMapping("/search")
	@ApiOperation(value="get all flights",response=FlightSearch.class)
	public List<FlightSearch> getAllflights(){
		return  flightSearchRepository.findAll();
		
	}
	//get flight by flight id
	@GetMapping("/search/{id}")
	@ApiOperation(value="get flight by id",
	              notes="provide the id of the flight to search it",
	              response=FlightSearch.class)
	public Optional<FlightSearch> getByFlightId(@PathVariable("id") long id){
		return flightSearchRepository.findById(id);
	}
	
	//get flight by origin
	@GetMapping("/search/origin/{origin}")
	@ApiOperation(value="get flight by origin",
	              notes="provide the origin of the flight to search it",
	              response=FlightSearch.class)
	public List<FlightSearch> getFlightByOrigin(@PathVariable("origin") String origin){
		return flightSearchRepository.getFlightByOrigin(origin);
	}
	//get flight by destination
	@GetMapping("/search/destination/{destination}")
	@ApiOperation(value="get flight by destination",
	              notes="provide the destination of the flight to search it",
	              response=FlightSearch.class)
	public List<FlightSearch> getFlightByDestination(@PathVariable("destination") String destination){
		return flightSearchRepository.getFlightByDestination(destination);
	}
	
	@GetMapping("/search/origin/destination/{origin}/{destination}")
	@ApiOperation(value="get flight by origin & destination",
	              notes="provide the origin & destination of the flight to search it",
	              response=FlightSearch.class)
	public List<FlightSearch> getFlightByOriginAndDestination(@PathVariable("origin") String origin,@PathVariable("destination") String destination){
		return flightSearchRepository.getFlightByOriginAndDestination(origin,destination);
	}
	
	
	//method to update the flight details
	@PutMapping("/search/update/{id}")
	@ApiOperation(value="update flight by id",
	              notes="provide the id of the flight to update it",
	              response=FlightSearch.class)
		public FlightSearch updateFlight(@PathVariable("id") long id, @RequestBody FlightSearch search) {
		FlightSearch searchdb = flightSearchRepository.getById(id);
		searchdb.setBusinessClassFare(search.getBusinessClassFare());
		searchdb.setDestination(search.getDestination());
		searchdb.setEconomyClassFare(search.getEconomyClassFare());
		searchdb.setFlightDate(search.getFlightDate());
		searchdb.setFlightName(search.getFlightName());
		searchdb.setFlightTime(search.getFlightTime());
		searchdb.setOrigin(search.getOrigin());
		
		return flightSearchRepository.save(searchdb);
		}
	
	//method to delete flights
	@DeleteMapping("/search/delete/{id}")
	@ApiOperation(value="delete flight by id",
	              notes="provide the id of the flight to delete it",
	              response=FlightSearch.class)
	public String deleteFlight(@PathVariable("id") long id) {
		flightSearchRepository.deleteById(id);
		return "deleted successfully";
		
	}

}
