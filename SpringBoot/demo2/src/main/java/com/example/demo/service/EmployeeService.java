package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	private final EmployeeRepository repository;

	public EmployeeService(EmployeeRepository repository) {
		this.repository = repository;
	}
	
	public List<Employee> findByDepartment(String dep) {
		return repository.findByDepartment(dep);
	}

	public List<Employee> findByHigherSalary(double salary) {
		return repository.findByHigherSalary(salary);
	}

	public List<Employee> findByPermanent() {
		return repository.findByPermanent();
	}

	public Integer countByDepartment(String dep) {
		return repository.countByDepartment(dep);
	}

	public Employee saveEmployee(Employee employee) {
		
		return repository.save(employee);
	}
}
