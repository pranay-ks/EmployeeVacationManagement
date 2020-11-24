package com.employee.domains;

import java.util.HashMap;
import java.util.Map;

import com.employee.exceptions.InvalidNumberOfDaysWorkedException;
import com.employee.exceptions.InvalidVacationDaysException;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "className")
public abstract class Employee {
	private int employeeId;
	private String name;
	protected float noOfVacationDays;
	protected int noOfDaysWorked;
	private String empType;
	public static final int TOTAL_NO_OF_WORKING_DAYS=260;
	public static Map<Integer, Float> vacBalance;
	static {
		vacBalance = new HashMap<Integer, Float>();
	}
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee(int employeeId, String name,String empType ) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.empType = empType;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public float getNoOfVacationDays() {
		return noOfVacationDays;
	}

	public void setNoOfVacationDays(float noOfVacationDays) {
		this.noOfVacationDays = noOfVacationDays;
	}
	
	public int getNoOfDaysWorked() {
		return noOfDaysWorked;
	}

	public void setNoOfDaysWorked(int noOfDaysWorked) {
		this.noOfDaysWorked = noOfDaysWorked;
	}
	

	public String getEmpType() {
		return empType;
	}

	public void setEmpType(String empType) {
		this.empType = empType;
	}

	public abstract void work(Employee emp)throws InvalidNumberOfDaysWorkedException;
	public abstract void takeVacation(Employee emp)throws InvalidVacationDaysException;
}
