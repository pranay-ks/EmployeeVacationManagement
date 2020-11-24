import { Component, OnInit } from '@angular/core';
import { Employee } from './employee.model';
import { EmployeeService } from './employee.service';

@Component({
  selector: 'app-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.css']
})
export class EmployeesComponent implements OnInit {
  employees: Employee[];
  constructor(private employeeService: EmployeeService) { }

  ngOnInit(): void {
    this.employeeService.employeesUpdated.subscribe(emps=>{
      console.log(emps)
      this.employees=emps;
    });
    this.employeeService.fetchEmployees().subscribe(employees => {
      this.employees = employees;
      console.log(this.employees);
    })
  }

}
