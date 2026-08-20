package com.flightbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightbooking.dto.Flight;
import com.flightbooking.dto.Login;
import com.flightbooking.entity.Passenger;
import com.flightbooking.service.PassengerService;

@RestController
@RequestMapping("/passengers")
public class PassengerController {
	
	@Autowired
	PassengerService passengerService;

	@PostMapping("signup")
	public ResponseEntity<Passenger> signUp(@RequestBody Passenger passenger) {
		Passenger passenger1 = passengerService.signup(passenger);
		return new ResponseEntity<Passenger>(passenger1, HttpStatus.CREATED);
	}
	
	@PostMapping("update")
	public ResponseEntity<Passenger> Update(@RequestBody Passenger passenger) {
		Passenger passenger1 = passengerService.signup(passenger);
		return new ResponseEntity<Passenger>(passenger1, HttpStatus.CREATED);
	}
	
	@PostMapping("login")
	public ResponseEntity<String> login(@RequestBody Login login) {
		boolean isValidPassenger = passengerService.login(login.getEmail(), login.getPassword());
		if(isValidPassenger==true) {
			return new ResponseEntity<String> ("Login Sucessful!",HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String> ("Try again with valid credentials!",HttpStatus.CREATED);
		}		
	}
	
	@GetMapping("")
	public ResponseEntity<List<Passenger>> viewAllPassengers(){
		List<Passenger> passengers = passengerService.viewAll();
		return new ResponseEntity<List<Passenger>>(passengers, HttpStatus.OK);
	}
	
	@GetMapping("Id/{passengerId}")
	public ResponseEntity<Passenger> getPassengerById(@PathVariable long passengerId) {
		Passenger passenger1 = passengerService.searchById(passengerId);
		return new ResponseEntity<Passenger> (passenger1,HttpStatus.OK);
	}
	
	@GetMapping("Id/{passengerId}/Flights")
	public List<Flight> getFlightByPassengerId(@PathVariable long passengerId){
		return passengerService.getFlightByPassengerId(passengerId);
		 
	}
}
