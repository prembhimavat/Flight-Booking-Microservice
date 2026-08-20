package com.flightbooking.dto;

public class MakeBooking {
	private String flightClass;
	private String Journey;
	private long flightId;
	private long passengerId;
	public String getFlightClass() {
		return flightClass;
	}
	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}
	public String getJourney() {
		return Journey;
	}
	public void setJourney(String journey) {
		Journey = journey;
	}
	public long getFlightId() {
		return flightId;
	}
	public void setFlightId(long flightId) {
		this.flightId = flightId;
	}
	public long getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(long passengerId) {
		this.passengerId = passengerId;
	}
}
