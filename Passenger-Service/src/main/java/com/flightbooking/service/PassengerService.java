package com.flightbooking.service;

import java.util.List;

import com.flightbooking.dto.Flight;
import com.flightbooking.entity.Passenger;

public interface PassengerService {
	Passenger signup(Passenger passenger);
	boolean login(String email, String password);
	List<Passenger> viewAll();
	Passenger searchById(long passengerId);
	List<Flight> getFlightByPassengerId(long passengerId);
}
