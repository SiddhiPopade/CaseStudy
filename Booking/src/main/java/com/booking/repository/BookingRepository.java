package com.booking.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booking.models.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long>{

	List<Booking> getBookingByClasss(String classs);

	Optional<Booking> findByFlightId(long fid);

	//List<Booking> findByFlightSearchId(Long did);

	//@Query("select b from Booking b where b.classs=?1")
	//List<Booking> getBookingByClasss(String classs);


}
