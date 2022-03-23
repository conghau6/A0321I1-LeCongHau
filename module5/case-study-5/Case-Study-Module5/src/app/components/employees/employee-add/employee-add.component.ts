import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {EmployeeService} from "../../../services/employee.service";
import {Router} from "@angular/router";
import {IDegree} from "../../../../model/IDegree";

@Component({
  selector: 'app-employee-add',
  templateUrl: './employee-add.component.html',
  styleUrls: ['./employee-add.component.css']
})
export class EmployeeAddComponent implements OnInit {

  listDegree: IDegree[];

  public formAddNewEmployee: FormGroup;

  constructor(public formBuilder: FormBuilder,
              public employeeService: EmployeeService,
              public router: Router) { }

  ngOnInit(): void {
    this.formAddNewEmployee = this.formBuilder.group({
      fullName: ['', [Validators.required, Validators.minLength(5)]],
      position: [''],
      educationDegree: [''],
      division: [''],
      dateOfBirth: [''],
      idCard: [''],
      salary: [''],
      email: ['', [Validators.required, Validators.email]],
      phone: [''],
      address: ['']
    });
    this.getAllDegree();
  }

  getAllDegree(){
    this.employeeService.getAllDegrees().subscribe(data => {
      this.listDegree = data;
      console.log(this.listDegree);
    });
  }

  addEmployee() {
    console.log(this.formAddNewEmployee.value);
    this.employeeService.addNewEmployee(this.formAddNewEmployee.value).subscribe(data => {
      this.router.navigateByUrl('employee-list');
    });
  }

}
