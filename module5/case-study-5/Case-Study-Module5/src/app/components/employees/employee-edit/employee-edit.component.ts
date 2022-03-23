import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {EmployeeService} from "../../../services/employee.service";
import {IEmployee} from "../../../../model/IEmployee";
import {IDegree} from "../../../../model/IDegree";
@Component({
  selector: 'app-employee-edit',
  templateUrl: './employee-edit.component.html',
  styleUrls: ['./employee-edit.component.css']
})
export class EmployeeEditComponent implements OnInit {

  formEdit: FormGroup;
  employee: IEmployee;
  listDegree: IDegree[];

  constructor(private activeRouter: ActivatedRoute,
              private fb:FormBuilder,
              private router:Router,
              private employeeService: EmployeeService) { }

  ngOnInit(): void {
    this.createForm();
    this.getAllDegree();
    this.activeRouter.paramMap.subscribe(
      (param: ParamMap) => {
        const id = param.get('id');
        console.log(id);
        this.employeeService.getEmployeeById(id).subscribe(
          (data => {
            this.employee = data;
            this.formEdit.setValue(this.employee);
          })
        );
      }
    );
  }

  compareFn(c1: IDegree, c2: IDegree): boolean {
    return c1 && c2 ? c1.id === c2.id : c1 === c2;
  }

  getAllDegree(){
    this.employeeService.getAllDegrees().subscribe(data => {
      this.listDegree = data;
      console.log(this.listDegree);
    });
  }

  createForm(){
    this.formEdit = this.fb.group({
      id: [''],
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
    })
  }

  edit() {
    if(this.formEdit.valid){
      this.employeeService.updateEmployee(this.formEdit.value).subscribe(
        ()=>{
          this.router.navigateByUrl('/employee-list');
        },
        error => {
          console.log(error);
        }
      )
    }
  }
}
