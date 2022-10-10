package com.booking.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.http.ResponseEntity;

@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long bookingId;
	private String firstName;
	private String lastName;
	private String gender;
	private int noOfSeats;
	private String classs;

	private long flightId;

	public Booking(long bookingId, String firstName, String lastName, String gender, int noOfSeats, String classs,
			long flightId) {
		super();
		this.bookingId = bookingId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.noOfSeats = noOfSeats;
		this.classs = classs;
		this.flightId = flightId;
	}

	public Booking() {
	}

	public long getFlightId() {
		return flightId;
	}

	public void setFlightId(long flightId) {
		this.flightId = flightId;
	}

	/*
	 * public void setFlightSearch(ResponseEntity<FlightSearch> temp) { //
	 * this.flightSearch = temp; }
	 */

	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public String getClasss() {
		return classs;
	}

	public void setClasss(String classs) {
		this.classs = classs;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", firstName=" + firstName + ", lastName=" + lastName + ", gender="
				+ gender + ", noOfSeats=" + noOfSeats + ", classs=" + classs + "]";
	}

}
