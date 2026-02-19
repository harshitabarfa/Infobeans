package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.exception.DuplicateEmailException;
import com.example.demo.exception.InvalidAgeException;
import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.repository.StudentRepository;

import jakarta.transaction.Transactional;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepo;

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepo.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student ID " + id + " not found"));
    }

    public Student createStudent(Student student) {

        if (student.getAge() < 1)
            throw new InvalidAgeException("Age must be ≥ 1");

        if (studentRepo.existsByEmail(student.getEmail()))
            throw new DuplicateEmailException("Email already exists");

        return studentRepo.save(student);
    }

    public Student updateStudent(Long id, Student update) {
        Student existing = getStudentById(id);

        existing.setStudentName(update.getStudentName());
        existing.setEmail(update.getEmail());
        existing.setAge(update.getAge());

        return studentRepo.save(existing);
    }

    public void deleteStudent(Long id) {
        Student s = getStudentById(id);
        studentRepo.delete(s);
    }

    public List<Student> searchByName(String name) {
        return studentRepo.findByStudentNameContainingIgnoreCase(name);
    }

    public boolean emailExists(String email) {
        return studentRepo.existsByEmail(email);
    }

    public long countStudents() {
        return studentRepo.count();
    }

    @Transactional
    public void deleteByEmail(String email) {
        studentRepo.deleteByEmail(email);
    }

    public List<Student> sortedStudents(String sortBy, String order) {
        Sort sort = order.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        return studentRepo.findAll(sort);
    }
}
