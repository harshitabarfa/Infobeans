package com.second.EmployeeParking;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Parking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String spotNumber;
	private String location;

	public Parking() {
	}

	public Parking(String spotNumber, String location) {
		this.spotNumber = spotNumber;
		this.location = location;
	}

	public int getId() {
		return id;
	}

	public String getSpotNumber() {
		return spotNumber;
	}

	public void setSpotNumber(String spotNumber) {
		this.spotNumber = spotNumber;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "ParkingSpot [id=" + id + ", spotNumber=" + spotNumber + ", location=" + location + "]";
	}
}
