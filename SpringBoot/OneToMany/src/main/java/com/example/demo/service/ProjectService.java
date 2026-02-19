package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;

public interface ProjectService {
	public Department addDept(Department dept);
	public Employee addEmployeeToDepartment(Long deptId, Employee emp);
	public Department getDept(Long id);
	public List<Department> getAllDept();
	public List<Employee> getEmployeeByDept(Long deptId);
	public void delteDept(Long id);
	public int countEmployee(Long deptId);
}
