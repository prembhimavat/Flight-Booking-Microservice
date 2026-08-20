package com.flightbooking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;

@Entity
@Table(name="tbl_passenger")
public class Passenger {
	@Id
	@TableGenerator (name = "passenger_id_gen", table = "passenger_id_tab", pkColumnName="passenger_pk", valueColumnName ="passenger_val", pkColumnValue="passenger_pk_val", initialValue=500, allocationSize=1)
	@GeneratedValue (strategy = GenerationType.TABLE, generator="passenger_id_gen")
	private long passengerId;
	private String passengerName;
	private String email;
	private String password;
	private String passengerPassport;
	public long getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(long passengerId) {
		this.passengerId = passengerId;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassengerPassport() {
		return passengerPassport;
	}
	public void setPassengerPassport(String passengerPassport) {
		this.passengerPassport = passengerPassport;
	}
		
}