package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Book;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/getAll")
	public List<Employee> getAllEmployees() {
		List<Employee> list = employeeService.getEmployees();
		return list;
	}

	@PostMapping("/addEmployee")
	public Employee employeeAdd(@RequestBody Employee emp) {
		return employeeService.addEmployee(emp);
	}

	@GetMapping("/getEmployee/id/{id}")
	public Employee getBookById(@PathVariable int id) {
		return employeeService.getEmployeeById(id);
	}

	@GetMapping("/getEmployee/name/{name}")
	public Employee getEmployeeByName(@PathVariable String name) {
		return employeeService.getEmployeeByName(name);
	}

	@GetMapping("/removeEmployee/{id}")
	public String removeEmployee(@PathVariable int id) {
		return this.employeeService.removeEmployee(id);
	}

	@PutMapping("/updateEmployee/{id}")
	public Employee updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
		return employeeService.updateEmployee(id, employee);
	}

	@GetMapping("/search")
	public ResponseEntity<List<Employee>> searchEmployees(@RequestParam(required = false) String name,
			@RequestParam(required = false) Double salary, @RequestParam(required = false) String address) {
		List<Employee> emp = employeeService.findByNameSalaryAndCity(name, salary, address);
		return ResponseEntity.status(200).body(emp);
	}
}
