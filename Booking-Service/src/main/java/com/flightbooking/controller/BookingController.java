package com.flightbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightbooking.dto.CancelBooking;
import com.flightbooking.dto.Flight;
import com.flightbooking.dto.MakeBooking;
import com.flightbooking.dto.Passenger;
import com.flightbooking.entity.Booking;
import com.flightbooking.service.BookingService;

@RestController
@RequestMapping("/bookings")
public class BookingController {
	
	@Autowired
	BookingService bookingService;
	
	@PostMapping("addBooking")
	public Booking addBooking(@RequestBody MakeBooking makeBooking) {
		return bookingService.makeBooking(makeBooking);
	}
	
	@PostMapping("cancelBooking")
	public Booking cancelBooking(@RequestBody CancelBooking cancelBooking) {
		return bookingService.cancelBooking(cancelBooking);
	}
	
	@GetMapping("")
	public List<Booking> viewAllBookings(){
		return bookingService.viewAllBookings();
	}
	
	@GetMapping("Id/{bookingId}")
	public Booking getBookingById(@PathVariable long bookingId) {
		return bookingService.searchBookingByBookingId(bookingId);
	}
	
	@GetMapping("getAllBookingByPassengerId/{passengerId}")
	public List<Booking> getAllBookingByPassengerId(@PathVariable long passengerId){
		return bookingService.getAllBookingByPassengerId(passengerId);
	}
	
	@GetMapping("getAllBookingByFlightId/{flightId}")
	public List<Booking> getAllBookingByFlightId(@PathVariable long flightId){
		return bookingService.getAllBookingByFlightId(flightId);
	}
	
	@GetMapping("Id/{bookingId}/passengerDetail")
	public Passenger getPassengerDetailByBookingId(@PathVariable long bookingId) {
		return bookingService.getPassengerDetailByBookingId(bookingId);
	}

	@GetMapping("Id/{bookingId}/flightDetail")
	public Flight getFlightDetailByBookingId(@PathVariable long bookingId) {
		return bookingService.getFlightDetailByBookingId(bookingId);
	}
	
	@GetMapping("/destination/{destination}/source/{source}")
	public List<Booking> getBookingByLocation(@PathVariable String destination, @PathVariable String source) {
		return bookingService.searchByLocation(destination, source);
	}
}