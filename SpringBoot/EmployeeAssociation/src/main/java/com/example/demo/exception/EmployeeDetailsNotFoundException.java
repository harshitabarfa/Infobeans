package com.example.demo.exception;

public class EmployeeDetailsNotFoundException extends RuntimeException {
	public EmployeeDetailsNotFoundException(String msg) {
        super(msg);
    }
}
