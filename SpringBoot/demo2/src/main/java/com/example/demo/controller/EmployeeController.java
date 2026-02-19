package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@PostMapping("/add")
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
		try {
			Employee savedEmployee = service.saveEmployee(employee);
			return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error while saving employee: " + e.getMessage());
		}
	}

	@GetMapping("/department/{department}")
	public ResponseEntity<?> findByDepartment(@PathVariable String department) {
		List<Employee> employees = service.findByDepartment(department);

		if (employees != null && !employees.isEmpty()) {
			return ResponseEntity.ok(employees);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No employees found in this department");
		}
	}

	@GetMapping("/salary/{salary}")
	public ResponseEntity<?> findByHigherSalary(@PathVariable double salary) {
		List<Employee> employees = service.findByHigherSalary(salary);

		if (employees != null && !employees.isEmpty()) {
			return ResponseEntity.ok(employees);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No employees found with higher salary");
		}
	}

	@GetMapping("/count/{department}")
	public ResponseEntity<?> countByDepartment(@PathVariable String department) {
		Integer count = service.countByDepartment(department);

		if (count != null && count > 0) {
			return ResponseEntity.ok(count);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No employees found in this department");
		}
	}

	@GetMapping("/permanent")
	public ResponseEntity<?> findByPermanent() {
		List<Employee> employees = service.findByPermanent();

		if (employees != null && !employees.isEmpty()) {
			return ResponseEntity.ok(employees);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No permanent employees found");
		}
	}
}