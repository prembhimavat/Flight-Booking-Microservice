package com.flightbooking.dto;

public class CancelBooking {
	private long passengerId;
	private long bookingId;
	public long getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(long passengerId) {
		this.passengerId = passengerId;
	}
	public long getBookingId() {
		return bookingId;
	}
	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}
	
}