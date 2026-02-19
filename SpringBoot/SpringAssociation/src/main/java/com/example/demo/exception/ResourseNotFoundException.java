package com.example.demo.exception;

public class ResourseNotFoundException extends RuntimeException {
	public ResourseNotFoundException(String msg) {
		super(msg);
	}
}
