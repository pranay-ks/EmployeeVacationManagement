package com.employee.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.domains.Employee;
import com.employee.exceptions.InvalidNumberOfDaysWorkedException;
import com.employee.exceptions.InvalidVacationDaysException;
import com.employee.services.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	@GetMapping("/")
	public List<Employee> getEmployees()
	{
		return employeeService.getEmployees();
	}
	@PostMapping("/")
	public void updateEmployee(@RequestBody Employee emp) throws InvalidNumberOfDaysWorkedException, InvalidVacationDaysException {
		employeeService.updateEmployee(emp);
	}	
}
