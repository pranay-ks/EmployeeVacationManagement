import { HttpErrorResponse } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Employee } from 'src/app/employees/employee.model';
import { EmployeeService } from 'src/app/employees/employee.service';
import { EmployeeDto } from 'src/app/employees/employeedto.model';

@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.css']
})
export class ModalComponent implements OnInit {
  employeeId: number;
  modalTitle: string;
  failure: boolean = false;
  isModelDisplayed: boolean = false;
  employees: Employee[] = [];
  emp: Employee;
  constructor(private employeeService: EmployeeService) {
    this.employeeService.modalDisplayEvent.subscribe((employeeData: EmployeeDto) => {
      this.modalTitle = employeeData.modalTitle;
      this.isModelDisplayed = employeeData.isModalDisplayed;
      this.employeeId = employeeData.id;
    });
  }
  ngOnInit(): void {
    this.employeeService.fetchEmployees().subscribe((emps) => {
      this.employees = emps;
    });
  }
  onSubmit(f: NgForm) {
    this.isModelDisplayed = false;
    const employeeIndex = this.employees.findIndex((emp) => {
      return emp.employeeId === this.employeeId;
    });
    const employee = this.employees[employeeIndex];
    if (this.modalTitle === 'Working Days') {
      if(f.value.days < 0){
        alert("Number of days cannot be less than 0");
      }else{
      employee.noOfDaysWorked = f.value.days;
      }
    }
    if (this.modalTitle === 'Vacation Days') {
      if(f.value.days < 0){
        alert("Accumulated vacation cannot be less than 0");
      }else{
      employee.noOfVacationDays = f.value.days;
      }
    }
    this.employeeService.updateEmployee(employee).subscribe((res) => {
      this.employeeService.fetchEmployees().subscribe((emps) => {
        this.employeeService.employeesUpdated.next(emps);
      });
     
      console.log("successfully updated");
    }, (error: HttpErrorResponse) => {
      this.employeeService.fetchEmployees().subscribe((emps) => {
        this.employees = emps;
      });
      alert(error.error.message);
    });
   
  }

  cancel() {
    this.isModelDisplayed = false;
  }
  onClose() {
    this.failure = false;
  }
}
