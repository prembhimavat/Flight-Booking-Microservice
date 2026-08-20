package com.flightbooking.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightbooking.dto.Passenger;
import com.flightbooking.entity.Flight;
import com.flightbooking.service.FlightService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/flights")
public class FlightController {
	
	@Autowired
	FlightService flightService;
	
	@PostMapping("addFlight")
	public Flight addFlight(@RequestBody Flight flight) {
		return flightService.addFlight(flight);
	}
	
	@PostMapping("updateFlight")
	public Flight updateFlight(@RequestBody Flight flight) {
		return flightService.addFlight(flight);
	}
	
	@GetMapping("")
	public List<Flight> viewAllFlights(){
		return flightService.viewAllFlight();
	}
	
	@GetMapping("Id/{flightId}")
	public Flight getFlightById(@PathVariable long flightId) {
		return flightService.searchById(flightId);
	}
	
	@GetMapping("date/{flightDate}")
	public Flight getFlightByDate(@PathVariable LocalDate flightDate) {
		return flightService.searchByDate(flightDate);
	}
	
	@GetMapping("Id/{flightId}/Passengers")
	@CircuitBreaker(name="cbflight", fallbackMethod="cbFallback")
	public List<Passenger> getAllPassengerByFlightId(@PathVariable long flightId){
		return flightService.getAllPassengersByFlightId(flightId);
	}
	
	@GetMapping("destination/{destination}/source/{source}")
	public List<Flight> searchByDestinationAndSource(@PathVariable String destination, @PathVariable String source){
		return flightService.searchByDestinationAndSource(destination, source);
	}
	
	public List<Passenger> cbFallback(@PathVariable long flightId, Exception exception) {
		System.out.println(exception.getMessage());
		List<Passenger> pass = new ArrayList<>();
		pass.add(null);
		return pass;
	}
}