package com.employee.exceptions;

public class InvalidVacationDaysException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public InvalidVacationDaysException(String desc) {
		super(desc);
	}
}
