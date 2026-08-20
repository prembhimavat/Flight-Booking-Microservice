package com.flightbooking.dto;

public class Passenger {
	private long passengerId;
	private String passengerName;
	private String email;
	private String password;
	private String passengerPassport;
	
	public long getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(long passengerId) {
		this.passengerId = passengerId;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassengerPassport() {
		return passengerPassport;
	}
	public void setPassengerPassport(String passengerPassport) {
		this.passengerPassport = passengerPassport;
	}
}