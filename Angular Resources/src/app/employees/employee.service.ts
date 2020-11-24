import { EventEmitter, Injectable, OnInit } from '@angular/core';
import { Employee } from './employee.model';
import {HttpClient} from '@angular/common/http';
import { Observable, Subject } from 'rxjs';
import { EmployeeDto } from './employeedto.model';
@Injectable({
    providedIn:"root"
})
export class EmployeeService
{
    employees:Employee[]=[];
    employeeChanged=new EventEmitter<number>();
    modalDisplayEvent=new EventEmitter<EmployeeDto>();
    employeesUpdated=new Subject<Employee[]>();
    constructor(private http:HttpClient){
    }
    fetchEmployees():Observable<any>{
        return this.http.get<Employee[]>('http://localhost:9022');
    }
    updateEmployee(emp:Employee):Observable<any>
    {
        return this.http.post<Employee>('http://localhost:9022',emp);
    }
}