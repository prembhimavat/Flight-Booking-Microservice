package com.flightbooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightbooking.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>{
	Booking findByBookingId(long bookingId);
	Booking findByBookingIdAndPassengerId(long bookingId, long passengerId);
	List<Booking> findByPassengerId(long passengerId);
	List<Booking> findByFlightId(long flightId);
}
