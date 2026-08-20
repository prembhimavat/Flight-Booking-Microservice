package com.flightbooking.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightbooking.dto.Booking;
import com.flightbooking.dto.Flight;
import com.flightbooking.entity.Passenger;
import com.flightbooking.feign.BookingFeign;
import com.flightbooking.feign.FlightFeign;
import com.flightbooking.repository.PassengerRepository;

@Service
public class PassengerServiceImpl implements PassengerService{
	
	@Autowired
	PassengerRepository passengerRepository;
	
	@Autowired
	BookingFeign bookingFeign;
	
	@Autowired
	FlightFeign flightFeign;

	@Override
	public Passenger signup(Passenger passenger) {
		return passengerRepository.save(passenger);
	}

	@Override
	public boolean login(String email, String password) {
		Passenger passenger = passengerRepository.findByEmailAndPassword(email, password);
		return passenger!=null?true:false;
	}

	@Override
	public List<Passenger> viewAll() {
		return passengerRepository.findAll();
	}

	@Override
	public Passenger searchById(long passengerId) {
		return passengerRepository.findByPassengerId(passengerId);
	}

	@Override
	public List<Flight> getFlightByPassengerId(long passengerId) {
		List<Booking> bookings = bookingFeign.getAllBookingByPassengerId(passengerId);
		List<Flight> flights = new ArrayList<>();
		for(Booking booking: bookings) {
			if(booking.isBookingStatus()==true) {
				flights.add(flightFeign.getFlightById(booking.getFlightId()));
			}
		}
		return flights;
	}
}