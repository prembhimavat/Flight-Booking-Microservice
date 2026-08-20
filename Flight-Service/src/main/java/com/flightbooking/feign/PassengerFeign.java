package com.flightbooking.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.flightbooking.dto.Passenger;

@FeignClient(name="PASSENGER-SERVICE")
public interface PassengerFeign {
	
	@GetMapping("passengers/Id/{passengerId}")
	ResponseEntity<Passenger> getPassengerById(@PathVariable long passengerId);
}
