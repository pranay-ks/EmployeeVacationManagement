package com.employee.util;

public enum EmployeeEnum {
	HOURLY_EMPLOYEE_VACATION_DAYS_PER_YEAR(10),
	SALARIED_EMPLOYEE_VACATION_DAYS_PER_YEAR(15),
	MANAGER_VACATION_DAYS_PER_YEAR(30);
	private int maxNoOfVacationDays;
	private EmployeeEnum(int maxNofVacationDays) {
		this.maxNoOfVacationDays=maxNofVacationDays;
	}
	public int getMaxNoOfVacationDays() {
		return maxNoOfVacationDays;
	}
	
}
