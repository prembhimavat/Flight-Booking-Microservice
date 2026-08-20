package com.flightbooking.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.flightbooking.dto.Booking;
import com.flightbooking.dto.Passenger;
import com.flightbooking.entity.Flight;
import com.flightbooking.feign.BookingFeign;
import com.flightbooking.feign.PassengerFeign;
import com.flightbooking.repository.FlightRepository;


@Service
public class FlightServiceImpl implements FlightService {
	
	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	BookingFeign bookingFeign;
	
	@Autowired
	PassengerFeign passengerFeign;

	@Override
	public Flight addFlight(Flight flight) {
		return flightRepository.save(flight);
	}

	@Override
	public Flight searchById(long flightId) {
		return flightRepository.findByFlightId(flightId);
	}

	@Override
	public Flight searchByDate(LocalDate flightDate) {
		return flightRepository.findByFlightDate(flightDate);
	}

	@Override
	public List<Flight> viewAllFlight() {
		return flightRepository.findAll();
	}

	@Override
	public List<Passenger> getAllPassengersByFlightId(long flightId) {
		List<Booking> bookings = bookingFeign.getAllBookingByFlightId(flightId);
		List<Passenger> passengers = new ArrayList<>();
		for(Booking booking2: bookings) {
			long id = booking2.getFlightId();
			Passenger passenger = passengerFeign.getPassengerById(id).getBody();
			passengers.add(passenger);
		}
		return passengers;
	}
	

	@Override
	public List<Flight> searchByDestinationAndSource(String destination, String source) {
		return flightRepository.findByDestinationAndSource(destination, source);
	}
	
}