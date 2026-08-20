package com.flightbooking.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightbooking.dto.CancelBooking;
import com.flightbooking.dto.Flight;
import com.flightbooking.dto.MakeBooking;
import com.flightbooking.dto.Passenger;
import com.flightbooking.entity.Booking;
import com.flightbooking.feign.FlightFeign;
import com.flightbooking.feign.PassengerFeign;
import com.flightbooking.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService{
	
	@Autowired
	BookingRepository bookingRepository;
	
	@Autowired
	PassengerFeign passengerFeign;
	
	@Autowired
	FlightFeign flightFeign;
	

	@Override
	public Booking makeBooking(MakeBooking makeBooking) {
		Booking booking = new Booking();
		booking.setBookingStatus(true);
		booking.setFlightClass(makeBooking.getFlightClass());
		booking.setJourney(makeBooking.getJourney());
		booking.setFlightId(makeBooking.getFlightId());
		booking.setPassengerId(makeBooking.getPassengerId());
		return bookingRepository.save(booking);
	}

	@Override
	public List<Booking> viewAllBookings() {
		return bookingRepository.findAll();
	}

	@Override
	public Booking searchBookingByBookingId(long bookingId) {
		return bookingRepository.findByBookingId(bookingId);
	}

	@Override
	public Booking cancelBooking(CancelBooking cancelBooking) {
		Booking booking = bookingRepository.findByBookingIdAndPassengerId(cancelBooking.getBookingId(), cancelBooking.getPassengerId());
		if(booking!=null) {
			booking.setBookingStatus(false);
			bookingRepository.save(booking);
			return booking;
		}
		return null;
	}

	@Override
	public List<Booking> getAllBookingByPassengerId(long passengerId) {
		return bookingRepository.findByPassengerId(passengerId);
	}

	@Override
	public List<Booking> getAllBookingByFlightId(long flightId) {
		return bookingRepository.findByFlightId(flightId);
	}

	@Override
	public Passenger getPassengerDetailByBookingId(long bookingId) {
		Booking booking = searchBookingByBookingId(bookingId);
		return passengerFeign.getPassengerById(booking.getPassengerId());
	}

	@Override
	public Flight getFlightDetailByBookingId(long bookingId) {
		Booking booking = searchBookingByBookingId(bookingId);
		System.out.println(booking);
		System.out.print(flightFeign.getFlightById(booking.getFlightId()));
		return flightFeign.getFlightById(booking.getFlightId());
	}

	@Override
	public List<Booking> searchByLocation(String destination, String source) {
		List<Flight> flights = flightFeign.searchByDestinationAndSource(destination, source);
		List<Booking> bookings = new ArrayList<>();
		for(Flight flight:flights) {
			bookings.addAll(bookingRepository.findByFlightId(flight.getFlightId()));
		}
		return bookings;
	}
}