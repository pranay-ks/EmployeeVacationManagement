import { Component, Input, OnInit, Output } from '@angular/core';
import { Employee } from '../employee.model';
import { EmployeeService } from '../employee.service';
import { EmployeeDto } from '../employeedto.model';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {
  @Input() employee: Employee;
  employeeType:string;
  constructor(private employeeService: EmployeeService) {
  }
  ngOnInit(): void {
    this.employeeType=this.employee.className.substring(this.employee.className.lastIndexOf('.')+1);
  }
  onSet(employee: EmployeeDto) {
    this.employeeService.modalDisplayEvent.emit(employee);
  }
}
