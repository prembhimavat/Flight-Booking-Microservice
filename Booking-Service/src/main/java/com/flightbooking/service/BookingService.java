package com.flightbooking.service;

import java.util.List;

import com.flightbooking.dto.CancelBooking;
import com.flightbooking.dto.Flight;
import com.flightbooking.dto.MakeBooking;
import com.flightbooking.dto.Passenger;
import com.flightbooking.entity.Booking;

public interface BookingService {
	Booking makeBooking(MakeBooking makeBooking);
	Booking cancelBooking(CancelBooking cancelBooking);
	List<Booking> viewAllBookings();
	Booking searchBookingByBookingId(long bookingId);
	List<Booking> getAllBookingByPassengerId(long passengerId);
	List<Booking> getAllBookingByFlightId(long flightId);
	Passenger getPassengerDetailByBookingId(long bookingId);
	Flight getFlightDetailByBookingId(long bookingId);
	List<Booking> searchByLocation(String destination, String source);
}