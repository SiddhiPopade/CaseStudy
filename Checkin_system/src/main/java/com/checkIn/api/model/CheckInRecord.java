package com.checkIn.api.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//model class

@Entity
public class CheckInRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String lastname;
	private String firstname;
	private long bookingId;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public long getBookingId() {
		return bookingId;
	}
	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}
	public CheckInRecord(long id, String lastname, String firstname, long bookingId) {
		super();
		this.id = id;
		this.lastname = lastname;
		this.firstname = firstname;
		this.bookingId = bookingId;
	}
	public CheckInRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CheckInRecord [id=" + id + ", lastname=" + lastname + ", firstname=" + firstname + ", bookingId="
				+ bookingId + "]";
	}
	
	
	
	
	
	}
