package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepo;

	public void save(Student s) {
		studentRepo.save(s);
	}

	public List<Student> getAll() {
		return studentRepo.findAll();
	}

	public Student getById(Long id) {
		return studentRepo.findById(id).orElse(null);
	}

	public void delete(Long id) {
		studentRepo.deleteById(id);
	}
}
