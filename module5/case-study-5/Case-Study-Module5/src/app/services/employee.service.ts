import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {IEmployee} from "../../model/IEmployee";
import {IDegree} from "../../model/IDegree";

@Injectable({
  providedIn: 'root'
})
export class EmployeeService{
  public API: string = "http://localhost:3000/employee";
  public API_DEGREE: string = 'http://localhost:3000/educationDegree';
  constructor(public http: HttpClient) {}

  getAllEmployees():Observable<any>{
    return this.http.get<IEmployee[]>(this.API);
  }

  getAllDegrees(): Observable<any>{
    return this.http.get<IDegree[]>(this.API_DEGREE);
  }

  addNewEmployee(employee: IEmployee):Observable<IEmployee>{
    return this.http.post<IEmployee>(this.API, employee);
  }

  getEmployeeById(id):Observable<any>{
    return this.http.get<IEmployee>(`${this.API}/${id}`);
  }

  updateEmployee(employee):Observable<any>{
    return this.http.put(`${this.API}/${employee.id}`,employee);
  }

  deleteEmployee(id):Observable<any>{
    return this.http.delete(`${this.API}/${id}`);
  }

  searchEmployee(obj: any): Observable<any>{
    return this.http.get(`${this.API}/?fullName_like=${obj.fullName}&email_like=${obj.email}&educationDegree.nameDegree_like=${obj.educationDegree}`)
  }
}
