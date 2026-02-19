package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	Optional<Employee> findByEmail(String email);

    void deleteByEmail(String email);

    List<Employee> findByDepartmentIgnoreCase(String department);

    List<Employee> findByNameContainingIgnoreCase(String keyword);

    List<Employee> findByJoiningDateAfter(LocalDate date);

    @Query("SELECT e FROM Employee e WHERE e.details.experience >= :minExp")
    List<Employee> findByExperience(int minExp);

    @Query("SELECT COUNT(e) FROM Employee e WHERE e.department = :department")
    long countByDepartment(String department);
}
