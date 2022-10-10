package com.flightbookingsystem.flightsearch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightbookingsystem.flightsearch.model.FlightSearch;

public interface FlightSearchRepository extends JpaRepository<FlightSearch, Long>  {

	List<FlightSearch> getFlightByOrigin(String origin);

	List<FlightSearch> getFlightByDestination(String destination);

	List<FlightSearch> getFlightByOriginAndDestination(String origin, String destination);

}
