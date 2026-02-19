package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.Vehicle;
import com.example.demo.service.VehicleService;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

	@Autowired
	private VehicleService service;

	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {
		List<Vehicle> list = service.getAll();

		if (list.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No vehicles found!");
		} else {
			return ResponseEntity.ok(list);
		}
	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<?> getById(@PathVariable int id) {
		Vehicle v = service.getById(id);

		if (v == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vehicle not found!");
		} else {
			return ResponseEntity.ok(v);
		}
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody Vehicle v) {
		Vehicle added = service.add(v);

		if (added != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(added);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Vehicle not added!");
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable int id, @RequestBody Vehicle v) {
		Vehicle updated = service.update(id, v);

		if (updated == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vehicle not found!");
		} else {
			return ResponseEntity.ok(updated);
		}
	}

	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<?> deleteById(@PathVariable int id) {
		String msg = service.deleteById(id);

		if (msg == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vehicle not found!");
		} else {
			return ResponseEntity.ok(msg);
		}
	}

	@GetMapping("/getByType/{type}")
	public ResponseEntity<?> getByType(@PathVariable String type) {
		List<Vehicle> list = service.getByType(type);

		if (list.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No vehicles of type: " + type);
		} else {
			return ResponseEntity.ok(list);
		}
	}

	@GetMapping("/getByStatus/{status}")
	public ResponseEntity<?> getByStatus(@PathVariable String status) {
		List<Vehicle> list = service.getByStatus(status);

		if (list.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No vehicles with status: " + status);
		} else {
			return ResponseEntity.ok(list);
		}
	}

	@DeleteMapping("/deleteByStatus/{status}")
	public ResponseEntity<?> deleteByStatus(@PathVariable String status) {
		String msg = service.deleteByStatus(status);

		if (msg.contains("No vehicles")) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
		} else {
			return ResponseEntity.ok(msg);
		}
	}

	@GetMapping("/getHighestCost")
	public ResponseEntity<?> getHighestCost() {
		Vehicle v = service.getHighestCost();

		if (v == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No vehicles found!");
		} else {
			return ResponseEntity.ok(v);
		}
	}

	@GetMapping("/getAverageCost")
	public ResponseEntity<?> getAverageCost() {
		double avg = service.getAverageCost();

		if (avg == 0.0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No data available!");
		} else {
			return ResponseEntity.ok(avg);
		}
	}

	@GetMapping("/getCount")
	public ResponseEntity<?> getCount() {
		int count = service.getCount();

		if (count == 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No vehicles available!");
		} else {
			return ResponseEntity.ok(count);
		}
	}

	@GetMapping("/getCostAbove/{amount}")
	public ResponseEntity<?> getCostAbove(@PathVariable double amount) {
		List<Vehicle> list = service.getCostAbove(amount);

		if (list.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No vehicles found above cost: " + amount);
		} else {
			return ResponseEntity.ok(list);
		}
	}

	@GetMapping("/search")
	public ResponseEntity<List<Vehicle>> searchVehicles(@RequestParam(required = false) String ownerName,
			@RequestParam(required = false) String vehicleType, @RequestParam(required = false) String serviceType,
			@RequestParam(required = false) Double cost, @RequestParam(required = false) String status) {

		List<Vehicle> result = service.findByOwnerVehicleTypeServiceTypeCostAndStatus(ownerName, vehicleType,
				serviceType, cost, status);

		return ResponseEntity.ok(result);
	}
}
