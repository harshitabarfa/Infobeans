package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	@Query("SELECT e FROM Employee e WHERE e.department = :dep")
	List<Employee> findByDepartment(@Param("dep") String dep);

	@Query("SELECT e FROM Employee e WHERE e.salary > :salary")
	List<Employee> findByHigherSalary(@Param("salary") double salary);

	@Query("SELECT e FROM Employee e WHERE e.permanent = true")
	List<Employee> findByPermanent();

	@Query("SELECT COUNT(e) FROM Employee e WHERE e.department = :department")
	Integer countByDepartment(@Param("department") String department);
}
