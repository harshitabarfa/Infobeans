package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.entity.EmployeeDetails;
import com.example.demo.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@GetMapping
	public ResponseEntity<?> getAll() {
		List<Employee> list = service.getAll();
		return list.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) {
		return ResponseEntity.ok(service.getById(id));
	}

	@PostMapping
	public ResponseEntity<?> create(@RequestBody Employee employee) {
		Employee created = service.create(employee);
		return ResponseEntity.status(201).body(created);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Employee employee) {
		return ResponseEntity.ok(service.update(id, employee));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/email/{email}")
	public ResponseEntity<?> deleteByEmail(@PathVariable String email) {
		service.deleteByEmail(email);
		return ResponseEntity.ok("Deleted employee with email = " + email);
	}

	@GetMapping("/department/{department}")
	public ResponseEntity<?> byDepartment(@PathVariable String department) {
		List<Employee> list = service.getByDepartment(department);
		return list.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(list);
	}

	@GetMapping("/name/{keyword}")
	public ResponseEntity<?> searchName(@PathVariable String keyword) {
		List<Employee> list = service.searchByName(keyword);
		return list.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(list);
	}

	@GetMapping("/joined-after")
	public ResponseEntity<?> joinedAfter(@RequestParam LocalDate date) {
		List<Employee> list = service.joinedAfter(date);
		return list.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(list);
	}

	@GetMapping("/experience")
	public ResponseEntity<?> minExperience(@RequestParam int minExp) {
		List<Employee> list = service.minExperience(minExp);
		return list.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(list);
	}

	@GetMapping("/count/{department}")
	public ResponseEntity<?> countDept(@PathVariable String department) {
		long count = service.countByDept(department);
		return ResponseEntity.ok(count);
	}

	@GetMapping("/details")
	public ResponseEntity<?> getAllDetails() {
		List<EmployeeDetails> list = service.getAllDetails();
		return list.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(list);
	}

	@GetMapping("/details/by-dob")
	public ResponseEntity<?> getByDob(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {

		List<EmployeeDetails> list = service.byDob(startDate, endDate);
		return list.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(list);
	}

	@GetMapping("/{id}/details")
	public ResponseEntity<?> getDetails(@PathVariable Long id) {
		EmployeeDetails details = service.getEmployeeDetails(id);
		return ResponseEntity.ok(details);
	}

	@PutMapping("/{id}/details")
	public ResponseEntity<?> updateDetails(@PathVariable Long id, @RequestBody EmployeeDetails details) {
		EmployeeDetails updated = service.updateDetails(id, details);
		return ResponseEntity.ok(updated);
	}

	@GetMapping("/details/by-experience")
	public ResponseEntity<?> getByExperience(@RequestParam int minExp, @RequestParam int maxExp) {

		List<EmployeeDetails> list = service.byExperienceRange(minExp, maxExp);
		return list.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(list);
	}
}
