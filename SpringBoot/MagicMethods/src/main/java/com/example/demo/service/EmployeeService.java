package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee addEmployee(Employee emp) {
		return employeeRepository.save(emp);
	}

	public List<Employee> getByDepartment(String dept) {
		// return employeeRepository.findByDepartment(dept);
		// return employeeRepository.findByDepartmentOrderByNameDesc(dept);
		return employeeRepository.findTop2ByDepartmentOrderByNameDesc(dept);
	}
}
