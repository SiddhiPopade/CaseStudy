package com.checkIn.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.checkIn.api.model.Booking;
import com.checkIn.api.model.CheckInRecord;

public interface CheckInRepository extends JpaRepository<CheckInRecord, Long>{

	List<CheckInRecord> findByBookingId(Long bookingId);

	CheckInRecord save(Booking book);

}
