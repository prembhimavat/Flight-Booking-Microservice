package com.flightbooking.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightbooking.entity.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long>{
	Flight findByFlightId(long flightId);
	Flight findByFlightDate(LocalDate flightDate);
	List<Flight> findByDestinationAndSource(String destination, String source);
}
