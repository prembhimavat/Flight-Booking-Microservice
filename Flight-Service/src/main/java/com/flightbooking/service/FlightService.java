package com.flightbooking.service;

import java.time.LocalDate;
import java.util.List;

import com.flightbooking.dto.Passenger;
import com.flightbooking.entity.Flight;

public interface FlightService {
	Flight addFlight(Flight flight);
	Flight searchById(long flightId);
	Flight searchByDate(LocalDate flightDate);
	List<Flight> viewAllFlight();
	List<Flight> searchByDestinationAndSource(String destination, String source);
	List<Passenger> getAllPassengersByFlightId(long flightId);
}
