package com.flightbooking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;

@Entity
@Table(name="tbl_booking")
public class Booking {
	@Id
	@TableGenerator (name = "booking_id_gen", table = "booking_id_tab", pkColumnName="booking_pk", valueColumnName ="booking_val", pkColumnValue="booking_pk_val", initialValue=0, allocationSize=1)
	@GeneratedValue (strategy = GenerationType.TABLE, generator="booking_id_gen")
	private long bookingId;
	private boolean bookingStatus;
	private String flightClass;
	private String Journey;
	private long flightId;
	private long passengerId;
	public long getBookingId() {
		return bookingId;
	}
	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}
	public boolean isBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(boolean bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
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