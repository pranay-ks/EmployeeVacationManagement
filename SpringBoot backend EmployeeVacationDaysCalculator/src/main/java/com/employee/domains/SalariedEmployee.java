package com.employee.domains;

import com.employee.exceptions.InvalidNumberOfDaysWorkedException;
import com.employee.exceptions.InvalidVacationDaysException;
import com.employee.util.EmployeeEnum;

public class SalariedEmployee extends Employee {
	public SalariedEmployee() {
		// TODO Auto-generated constructor stub
	}

	public SalariedEmployee(int employeeId, String name, String type) {
		super(employeeId, name, type);
	}

	@Override
	public void work(Employee emp) throws InvalidNumberOfDaysWorkedException {
		if (emp.getNoOfDaysWorked() > TOTAL_NO_OF_WORKING_DAYS) {
			throw new InvalidNumberOfDaysWorkedException("Number of days worked should be less than 260 days!");
		} else {
			// this.noOfVacationDays = TOTAL_NO_OF_WORKING_DAYS - noOfDaysWorked;
			if ("manager".equals(emp.getEmpType())) {
				this.noOfVacationDays = 30;
			} else {
				this.noOfVacationDays = 15;
			}
			this.noOfDaysWorked = emp.getNoOfDaysWorked();
			Employee.vacBalance.put(emp.getEmployeeId(), this.noOfVacationDays);

		}
	}

	@Override
	public void takeVacation(Employee emp) throws InvalidVacationDaysException {
		if (Employee.vacBalance.get(emp.getEmployeeId()) == null) {
			throw new InvalidVacationDaysException("First set number of working days");
		} else {
			if (emp.getNoOfVacationDays() > EmployeeEnum.SALARIED_EMPLOYEE_VACATION_DAYS_PER_YEAR
					.getMaxNoOfVacationDays()) {
				throw new InvalidVacationDaysException("Error: This Employee cannot accumulate more than "
						+ EmployeeEnum.SALARIED_EMPLOYEE_VACATION_DAYS_PER_YEAR.getMaxNoOfVacationDays()
						+ " days of Vacation per year!");
			} else if (emp.getNoOfVacationDays() <= Employee.vacBalance.get(emp.getEmployeeId())) {

				float vacBal = Employee.vacBalance.get(emp.getEmployeeId());
				float balance = vacBal - emp.getNoOfVacationDays();
				Employee.vacBalance.put(emp.getEmployeeId(), balance);
				this.noOfVacationDays = balance;

			} else {
				throw new InvalidVacationDaysException("No enough vacation days to avail");
			}
		}
	}
}
