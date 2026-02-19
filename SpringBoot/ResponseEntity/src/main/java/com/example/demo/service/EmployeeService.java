package com.example.demo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;
import com.example.demo.entity.Employee;

@Service
public class EmployeeService {
	public static List<Employee> list = new ArrayList<>();

	static {
		list.add(new Employee(101, "Harshita", 80000, "Indore"));
		list.add(new Employee(102, "Mayuri", 90000, "Pune"));
		list.add(new Employee(103, "Shraddha", 70000, "Chennai"));
	}

	public List<Employee> getEmployees() {
		return list;
	}

	public Employee addEmployee(Employee emp) {
		list.add(emp);
		return emp;
	}

	public Employee getEmployeeById(int id) {
		Iterator<Employee> itr = list.iterator();

		Employee emp = null;
		while (itr.hasNext()) {
			emp = itr.next();
			if (emp.getId() == id) {
				return emp;
			}
		}
		return null;
	}

	public Employee getEmployeeByName(String name) {
		Iterator<Employee> itr = list.iterator();

		Employee emp = null;
		while (itr.hasNext()) {
			emp = itr.next();
			if (emp.getName().equalsIgnoreCase(name)) {
				return emp;
			}
		}
		return null;
	}

	public String removeEmployee(int id) {
		Iterator<Employee> itr = list.iterator();

		Employee emp = null;
		while (itr.hasNext()) {
			emp = itr.next();
			if (emp.getId() == id) {
				itr.remove();
				return "Employee deleted successfully!";
			}
		}
		return "Employee not found";
	}

	public Employee updateEmployee(int id, Employee employee) {
		Iterator<Employee> itr = list.iterator();

		while (itr.hasNext()) {
			Employee emp = itr.next();

			if (emp.getId() == id) {
				emp.setName(employee.getName());
				emp.setSalary(employee.getSalary());
				emp.setAddress(employee.getAddress());
				return emp;
			}
		}
		return null;
	}
}
