package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.entity.EmployeeDetails;
import com.example.demo.exception.EmailAlreadyExistsException;
import com.example.demo.exception.EmployeeDetailsNotFoundException;
import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.exception.InvalidExperienceException;
import com.example.demo.repository.EmployeeDetailsRepository;
import com.example.demo.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepo;

	@Autowired
	private EmployeeDetailsRepository detailsRepo;

	public List<Employee> getAll() {
		return employeeRepo.findAll();
	}

	public Employee getById(Long id) {
		return employeeRepo.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
	}

	public Employee create(Employee emp) {

		employeeRepo.findByEmail(emp.getEmail()).ifPresent(e -> {
			throw new EmailAlreadyExistsException("Email already exists");
		});

		if (emp.getDetails() != null && emp.getDetails().getExperience() < 0) {
			throw new InvalidExperienceException("Experience must be >= 0");
		}

		return employeeRepo.save(emp);
	}

	public Employee update(Long id, Employee emp) {
		Employee existing = getById(id);

		existing.setName(emp.getName());
		existing.setEmail(emp.getEmail());
		existing.setDepartment(emp.getDepartment());
		existing.setJoiningDate(emp.getJoiningDate());

		if (emp.getDetails() != null) {
			if (emp.getDetails().getExperience() < 0)
				throw new InvalidExperienceException("Experience must be >= 0");

			if (existing.getDetails() == null) {
				existing.setDetails(emp.getDetails());
			} else {
				EmployeeDetails existingDetails = existing.getDetails();
				existingDetails.setDateOfBirth(emp.getDetails().getDateOfBirth());
				existingDetails.setExperience(emp.getDetails().getExperience());
			}
		}
		return employeeRepo.save(existing);
	}

	public void delete(Long id) {
		if (!employeeRepo.existsById(id))
			throw new EmployeeNotFoundException("Employee not found");

		employeeRepo.deleteById(id);
	}

	public void deleteByEmail(String email) {
		Employee emp = employeeRepo.findByEmail(email)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
		employeeRepo.delete(emp);
	}

	public List<Employee> getByDepartment(String dept) {
		return employeeRepo.findByDepartmentIgnoreCase(dept);
	}

	public List<Employee> searchByName(String keyword) {
		return employeeRepo.findByNameContainingIgnoreCase(keyword);
	}

	public List<Employee> joinedAfter(LocalDate date) {
		return employeeRepo.findByJoiningDateAfter(date);
	}

	public List<Employee> minExperience(int exp) {
		return employeeRepo.findByExperience(exp);
	}

	public long countByDept(String dept) {
		return employeeRepo.countByDepartment(dept);
	}

	public EmployeeDetails getEmployeeDetails(Long employeeId) {
		Employee emp = getById(employeeId);

		if (emp.getDetails() == null)
			throw new EmployeeDetailsNotFoundException("Details not found");

		return emp.getDetails();
	}

	public EmployeeDetails updateDetails(Long employeeId, EmployeeDetails details) {

		if (details == null)
			throw new IllegalArgumentException("Details body cannot be empty");

		if (details.getExperience() < 0)
			throw new InvalidExperienceException("Experience must be >= 0");

		Employee emp = getById(employeeId);

		emp.setDetails(details);
		employeeRepo.save(emp);

		return details;
	}

	public List<EmployeeDetails> getAllDetails() {
		return detailsRepo.findAll();
	}

	public List<EmployeeDetails> byDob(LocalDate start, LocalDate end) {
		return detailsRepo.findByDobRange(start, end);
	}

	public List<EmployeeDetails> byExperienceRange(int minExp, int maxExp) {
		return detailsRepo.findByExperienceRange(minExp, maxExp);
	}
}
