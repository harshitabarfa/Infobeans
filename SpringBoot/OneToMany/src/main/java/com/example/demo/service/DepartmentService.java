package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;

@Service
public class DepartmentService implements ProjectService {
	@Autowired
	private DepartmentRepository deptRepo;
	
	@Autowired
	private EmployeeRepository empRepo;
	
	public Department addDept(Department dept) {
		return deptRepo.save(dept);
	}
	
	public Employee addEmployeeToDepartment(Long deptId, Employee emp) {
		Department dept = deptRepo.findById(deptId).get();
		
		emp.setDepartment(dept);
		return empRepo.save(emp);
	}
	
	public Department getDept(Long id) {
		return deptRepo.findById(id).get();
	}
	
	public List<Department> getAllDept(){
		return deptRepo.findAll();
	}
	
	public List<Employee> getEmployeeByDept(Long deptId) {
		Department dept = getDept(deptId);
		return dept.getEmployees();
	}
	
	public void delteDept(Long id) {
		Department dept = getDept(id);
		deptRepo.delete(dept);
	}
	
	public int countEmployee(Long deptId) {
		return getEmployeeByDept(deptId).size();
	}
}
