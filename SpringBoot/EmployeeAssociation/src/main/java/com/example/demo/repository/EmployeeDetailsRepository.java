package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Employee;
import com.example.demo.entity.EmployeeDetails;

public interface EmployeeDetailsRepository extends JpaRepository<EmployeeDetails, Long> {
	@Query("SELECT d FROM EmployeeDetails d WHERE d.dateOfBirth BETWEEN :start AND :end")
    List<EmployeeDetails> findByDobRange(LocalDate start, LocalDate end);

    @Query("SELECT d FROM EmployeeDetails d WHERE d.experience BETWEEN :min AND :max")
    List<EmployeeDetails> findByExperienceRange(int min, int max);
}
