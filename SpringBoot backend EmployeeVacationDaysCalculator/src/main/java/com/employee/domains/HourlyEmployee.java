package com.employee.domains;

import com.employee.exceptions.InvalidNumberOfDaysWorkedException;
import com.employee.exceptions.InvalidVacationDaysException;
import com.employee.util.EmployeeEnum;

public class HourlyEmployee extends Employee {
	public HourlyEmployee() {
		// TODO Auto-generated constructor stub
	}

	public HourlyEmployee(int employeeId, String name, String type) {
		super(employeeId, name, type);
	}

	@Override
	public void work(Employee emp) throws InvalidNumberOfDaysWorkedException {

		if (emp.getNoOfDaysWorked() > TOTAL_NO_OF_WORKING_DAYS) {
			throw new InvalidNumberOfDaysWorkedException("Number of days worked should be less than 260 days!");
		} else {
			// this.noOfVacationDays = TOTAL_NO_OF_WORKING_DAYS - emp.getNoOfDaysWorked();
			this.noOfDaysWorked = emp.getNoOfDaysWorked();
			if ("hourly".equals(emp.getEmpType())) {
				this.noOfVacationDays = 10;
			} else {
				this.noOfVacationDays = 30;
			}
			Employee.vacBalance.put(emp.getEmployeeId(), this.noOfVacationDays);
		}
	}

	@Override
	public void takeVacation(Employee emp) throws InvalidVacationDaysException {
		if (Employee.vacBalance.get(emp.getEmployeeId()) == null) {
			throw new InvalidVacationDaysException("First set number of working days");
		} else {
			if (emp.getNoOfVacationDays() > EmployeeEnum.HOURLY_EMPLOYEE_VACATION_DAYS_PER_YEAR
					.getMaxNoOfVacationDays()) {
				throw new InvalidVacationDaysException("Error: This employee cannot accumulate more than "
						+ EmployeeEnum.HOURLY_EMPLOYEE_VACATION_DAYS_PER_YEAR.getMaxNoOfVacationDays()
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
