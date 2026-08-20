package com.flightbooking.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.flightbooking.dto.Flight;

@FeignClient(name="FLIGHT-SERVICE")
public interface FlightFeign {
	
	@GetMapping("flights/Id/{flightId}")
	Flight getFlightById(@PathVariable long flightId);
}
