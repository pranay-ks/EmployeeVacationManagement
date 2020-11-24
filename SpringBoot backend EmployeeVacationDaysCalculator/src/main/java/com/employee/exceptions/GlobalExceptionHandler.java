package com.employee.exceptions;


import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	protected ResponseEntity<Object> handleMethodArgumentNotValid(InvalidNumberOfDaysWorkedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		System.out.println("Enter valid days");
		Map<String, Object> body = new LinkedHashMap<String, Object>();
		body.put("timestamp", new Date());
		body.put("status", status.value());
		body.put("message", "Please enter correct no of days");
		return new ResponseEntity<>(body, headers, status);
	}
	protected ResponseEntity<Object> handleMethodArgumentNotValid(InvalidVacationDaysException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		System.out.println("invalidvacationdaysexception");
		Map<String, Object> body = new LinkedHashMap<String, Object>();
		body.put("timestamp", new Date());
		body.put("status", status.value());
		body.put("message", "Vacation Days are Invalid");
		return new ResponseEntity<>(body, headers, status);
	}
	
}

