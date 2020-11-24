package com.employee.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.domains.Employee;
import com.employee.exceptions.InvalidNumberOfDaysWorkedException;
import com.employee.exceptions.InvalidVacationDaysException;
@Service
public class EmployeeService {
	List<Employee> employees=null;
	public EmployeeService() {
		// TODO Auto-generated constructor stub
	}
	public List<Employee> getEmployees(){
		return employees;
	}
	public void initData(List<Employee> employees) {
		this.employees=employees;
	}
	public Employee getEmployee(int id) {
		Employee employee=null;
		for(Employee emp:employees)
		{
			if(emp.getEmployeeId()==id)
			{
				employee=emp;
			}
		}
		return employee;
	}
	public void updateEmployee(Employee emp) throws InvalidNumberOfDaysWorkedException, InvalidVacationDaysException
	{
		Employee emp1=getEmployee(emp.getEmployeeId());
		emp1.setName(emp.getName());
		if(emp1.getNoOfDaysWorked()!=emp.getNoOfDaysWorked()) {
			emp1.work(emp);
		}
		if(emp1.getNoOfVacationDays()!=emp.getNoOfVacationDays())
		{
			emp1.takeVacation(emp);
		}
		
	}
}
