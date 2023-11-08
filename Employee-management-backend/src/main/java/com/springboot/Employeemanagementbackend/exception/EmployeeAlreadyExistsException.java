package com.springboot.Employeemanagementbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class EmployeeAlreadyExistsException extends RuntimeException {

	public EmployeeAlreadyExistsException(String message) {
		super(message);
	}

}
