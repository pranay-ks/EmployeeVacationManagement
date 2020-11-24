package com.employee.domains;

import com.employee.exceptions.InvalidVacationDaysException;
import com.employee.util.EmployeeEnum;

public class Manager extends SalariedEmployee {
	public Manager() {
		// TODO Auto-generated constructor stub
	}

	public Manager(int employeeId, String name, String type) {
		super(employeeId, name, type);
	}

	@Override
	public void takeVacation(Employee emp) throws InvalidVacationDaysException {
		if (Employee.vacBalance.get(emp.getEmployeeId()) == null) {
			throw new InvalidVacationDaysException("First set number of working days");
		} else {
			if (emp.getNoOfVacationDays() > EmployeeEnum.MANAGER_VACATION_DAYS_PER_YEAR.getMaxNoOfVacationDays()) {
				// System.out.println("hello");
				throw new InvalidVacationDaysException("Error: This employee cannot accumulate more than"
						+ EmployeeEnum.MANAGER_VACATION_DAYS_PER_YEAR.getMaxNoOfVacationDays()
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
