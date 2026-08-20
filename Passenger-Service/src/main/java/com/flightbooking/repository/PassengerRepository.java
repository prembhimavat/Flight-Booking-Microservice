package com.flightbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightbooking.entity.Passenger;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {
	Passenger findByEmailAndPassword(String email, String password);
	Passenger findByPassengerId(long passengerId);
}
