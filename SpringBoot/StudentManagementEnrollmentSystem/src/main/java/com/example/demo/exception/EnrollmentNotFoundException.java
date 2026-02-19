package com.example.demo.exception;

public class EnrollmentNotFoundException extends RuntimeException {
	public EnrollmentNotFoundException(String message) {
		super(message);
	}
}
