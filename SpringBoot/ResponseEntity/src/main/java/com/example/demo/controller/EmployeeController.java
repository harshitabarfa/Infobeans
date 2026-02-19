package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/getAll")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> list = employeeService.getEmployees();

		if (list == null || list.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(list);
		}
	}

	@PostMapping("/addEmployee")
	public ResponseEntity<Employee> employeeAdd(@RequestBody Employee emp) {
		Employee e = employeeService.addEmployee(emp);
		return ResponseEntity.status(201).body(e);
	}

	@GetMapping("/getEmployeeByid/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable("id") int id) {
		Employee e = employeeService.getEmployeeById(id);

		if (e == null) {
			return ResponseEntity.status(404).body("Not found!");
		} else {
			return ResponseEntity.status(200).body(e);
		}
	}

	@GetMapping("/getEmployeeByname/{name}")
	public ResponseEntity<?> getEmployeeByName(@PathVariable String name) {
		Employee e = employeeService.getEmployeeByName(name);

		if (e == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found!");
		} else {
			return ResponseEntity.status(200).body(e);
		}
	}

	@GetMapping("/removeEmployee/{id}")
	public ResponseEntity<String> removeEmployee(@PathVariable int id) {
		String s = employeeService.removeEmployee(id);

		if (s.equalsIgnoreCase("Employee not found")) {
			return ResponseEntity.status(404).body(s);
		} else {
			return ResponseEntity.status(200).body(s);
		}
	}

	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
		Employee e = employeeService.updateEmployee(id, employee);

		if (e != null) {
			return ResponseEntity.status(200).body(e);
		} else {
			return ResponseEntity.status(404).build();
		}
	}
}
