package com.employee.bootstrap;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.employee.domains.Employee;
import com.employee.domains.HourlyEmployee;
import com.employee.domains.Manager;
import com.employee.domains.SalariedEmployee;
import com.employee.services.EmployeeService;

@Component
public class EmployeeBootstrap implements ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	EmployeeService employeeService;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		employeeService.initData(getEmployees());
	}

	private List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<>();
		Employee employee1 = getEmployee(1, "Lewis", "salaried");
		Employee employee2 = getEmployee(2, "Daniel", "manager");
		Employee employee3 = getEmployee(3, "Vettel", "hourly");
		Employee employee4 = getEmployee(4, "Max", "salaried");
		Employee employee5 = getEmployee(5, "James", "manager");
		Employee employee6 = getEmployee(6, "Frank", "hourly");
		Employee employee7 = getEmployee(7, "Tom", "salaried");
		Employee employee8 = getEmployee(8, "Ben", "manager");
		Employee employee9 = getEmployee(9, "Peter", "hourly");
		Employee employee10 = getEmployee(10, "Franklin", "salaried");
		Employee employee11 = getEmployee(11, "King", "manager");
		Employee employee12 = getEmployee(12, "Miguel", "hourly");
		Employee employee13 = getEmployee(13, "Taylor", "salaried");
		Employee employee14 = getEmployee(14, "Christian", "manager");
		Employee employee15 = getEmployee(15, "Joanne", "hourly");
		Employee employee16 = getEmployee(16, "Jonah", "salaried");
		Employee employee17 = getEmployee(17, "Alice", "manager");
		Employee employee18 = getEmployee(18, "Jake", "hourly");
		Employee employee19 = getEmployee(19, "Minnie", "salaried");
		Employee employee20 = getEmployee(20, "Cindy", "manager");
		Employee employee21 = getEmployee(21, "Benjamin", "hourly");
		Employee employee22 = getEmployee(22, "Perez", "salaried");
		Employee employee23 = getEmployee(23, "Misty", "manager");
		Employee employee24 = getEmployee(24, "Alphonse", "hourly");
		Employee employee25 = getEmployee(25, "Bethany", "salaried");
		Employee employee26 = getEmployee(26, "Enrique", "manager");
		Employee employee27 = getEmployee(27, "Seth", "hourly");
		Employee employee28 = getEmployee(28, "Kimmy", "salaried");
		Employee employee29 = getEmployee(29, "Jimmy", "manager");
		Employee employee30 = getEmployee(30, "Maxwell", "hourly");
		Employee employee31 = getEmployee(31, "Peterson", "salaried");
		Employee employee32 = getEmployee(32, "Astra", "manager");
		Employee employee33 = getEmployee(33, "Kendall", "hourly");

		employees.add(employee1);
		employees.add(employee2);
		employees.add(employee3);
		employees.add(employee4);
		employees.add(employee5);
		employees.add(employee6);
		employees.add(employee7);
		employees.add(employee8);
		employees.add(employee9);
		employees.add(employee10);
		employees.add(employee11);
		employees.add(employee12);
		employees.add(employee13);
		employees.add(employee14);
		employees.add(employee15);
		employees.add(employee16);
		employees.add(employee17);
		employees.add(employee18);
		employees.add(employee19);
		employees.add(employee20);
		employees.add(employee21);
		employees.add(employee22);
		employees.add(employee23);
		employees.add(employee24);
		employees.add(employee25);
		employees.add(employee26);
		employees.add(employee27);
		employees.add(employee28);
		employees.add(employee29);
		employees.add(employee30);
		employees.add(employee31);
		employees.add(employee32);
		employees.add(employee33);
		return employees;
	}

	private Employee getEmployee(int id, String name, String type) {
		Employee employee = null;
		if (type.equals("salaried"))
			employee = new SalariedEmployee(id, name, type);
		else if (type.equals("hourly"))
			employee = new HourlyEmployee(id, name, type);
		else
			employee = new Manager(id, name, "manager");
		return employee;
	}

}
