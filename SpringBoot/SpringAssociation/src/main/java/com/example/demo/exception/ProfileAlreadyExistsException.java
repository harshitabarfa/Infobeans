package com.example.demo.exception;

public class ProfileAlreadyExistsException extends RuntimeException {
	public ProfileAlreadyExistsException(String msg) {
		super(msg);
	}
}
