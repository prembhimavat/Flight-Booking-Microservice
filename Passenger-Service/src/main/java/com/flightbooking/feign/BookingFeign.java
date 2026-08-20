package com.flightbooking.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.flightbooking.dto.Booking;

@FeignClient(name="BOOKING-SERVICE")
public interface BookingFeign {

	@GetMapping("bookings/getAllBookingByPassengerId/{passengerId}")
	List<Booking> getAllBookingByPassengerId(@PathVariable long passengerId);
}
