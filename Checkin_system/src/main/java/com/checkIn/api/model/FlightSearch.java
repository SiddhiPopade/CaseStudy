package com.checkIn.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description="Details about the flight")
public class FlightSearch {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@ApiModelProperty(notes="the unique id of the flight")
	 long id;
	@ApiModelProperty(notes="the name of the flight")
	 String flightName;
	@ApiModelProperty(notes="the date of the flight")
	 String flightDate;
	@ApiModelProperty(notes="the time of the flight")
	 String flightTime;
	@ApiModelProperty(notes="the origin of the flight")
	 String origin;
	@ApiModelProperty(notes="the destination of the flight")
	 String destination;
	@ApiModelProperty(notes="the business class fare of the flight")
	 int businessClassFare;
	@ApiModelProperty(notes="the economy class fare of the flight")
	 int economyClassFare;
	public FlightSearch(long id, String flightName, String flightDate, String flightTime, String origin,
			String destination, int businessClassFare, int economyClassFare) {
		super();
		this.id = id;
		this.flightName = flightName;
		this.flightDate = flightDate;
		this.flightTime = flightTime;
		this.origin = origin;
		this.destination = destination;
		this.businessClassFare = businessClassFare;
		this.economyClassFare = economyClassFare;
	}
	public FlightSearch() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public String getFlightDate() {
		return flightDate;
	}
	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}
	public String getFlightTime() {
		return flightTime;
	}
	public void setFlightTime(String flightTime) {
		this.flightTime = flightTime;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getBusinessClassFare() {
		return businessClassFare;
	}
	public void setBusinessClassFare(int businessClassFare) {
		this.businessClassFare = businessClassFare;
	}
	public int getEconomyClassFare() {
		return economyClassFare;
	}
	public void setEconomyClassFare(int economyClassFare) {
		this.economyClassFare = economyClassFare;
	}
	@Override
	public String toString() {
		return "FlightSearch [id=" + id + ", flightName=" + flightName + ", flightDate=" + flightDate + ", flightTime="
				+ flightTime + ", origin=" + origin + ", destination=" + destination + ", businessClassFare="
				+ businessClassFare + ", economyClassFare=" + economyClassFare + "]";
	}
}