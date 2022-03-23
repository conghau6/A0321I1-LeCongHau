import { Component, OnInit } from '@angular/core';
import {EmployeeService} from "../../../services/employee.service";
import {IEmployee} from "../../../../model/IEmployee";
import {IDegree} from "../../../../model/IDegree";
import {MatDialog} from "@angular/material/dialog";
import {EmployeeDeleteComponent} from "../employee-delete/employee-delete.component";
import {FormBuilder, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  public employees: IEmployee[];
  public degrees: IDegree[];
  p = 1;
  formSearch: FormGroup;
  id: number;
  fullName: string;

  constructor(public employeeService: EmployeeService,
              private fb: FormBuilder,
              private matDialog: MatDialog) { }

  ngOnInit(): void {
    this.createForm();
    this.employeeService.getAllEmployees().subscribe(data => {
      this.employees = data;
      console.log(this.employees);
    })
  }

  createForm(){
    this.formSearch = this.fb.group({
      fullName: [''],
      email: [''],
      educationDegree: ['']
    });
  }

  openDialogDelete(id: any, name: any) {
    const dialogDelete = this.matDialog.open(EmployeeDeleteComponent, {
      data: {id: id, name: name},
      height: '150px',
      width: '500px'
    });
    dialogDelete.afterClosed().subscribe(() => {
    });
  }

  search() {
    this.employeeService.searchEmployee(this.formSearch.value).subscribe(
      data => {
        this.p = 1;
        this.employees = data;
      }
    )
  }

  xoa(id: string) {
    this.employeeService.getEmployeeById(id).subscribe(
      data => {
        this.id = data.id;
      }
    );
  }

  deleteShip(id: number) {
    this.employeeService.deleteEmployee(id).subscribe();
  }
}
