package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.LocationTracking;
import com.example.demo.service.LocationTrackingService;

@RestController
@RequestMapping("/api/location")
@CrossOrigin
public class LocationTrackingController {

	@Autowired
	private LocationTrackingService locationService;

	@PostMapping
	public LocationTracking save(@RequestBody LocationTracking location) {
		return locationService.save(location);
	}

	@GetMapping
	public List<LocationTracking> getAll() {
		return locationService.getAllLocations();
	}
}
