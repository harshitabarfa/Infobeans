package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.LocationTracking;
import com.example.demo.repository.LocationTrackingRepository;

@Service
public class LocationTrackingService {
	@Autowired
	private LocationTrackingRepository locationRepo;

	public LocationTracking save(LocationTracking location) {
		return locationRepo.save(location);
	}

	public List<LocationTracking> getAllLocations() {
		return locationRepo.findAll();
	}
}
