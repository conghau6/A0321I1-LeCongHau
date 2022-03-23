import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from '@angular/material/dialog';
import {EmployeeService} from "../../../services/employee.service";
import {Router} from "@angular/router";
import {IEmployee} from "../../../../model/IEmployee";
@Component({
  selector: 'app-employee-delete',
  templateUrl: './employee-delete.component.html',
  styleUrls: ['./employee-delete.component.css']
})
export class EmployeeDeleteComponent implements OnInit {

  id: number;
  name: string;
  constructor(@Inject(MAT_DIALOG_DATA) data: any,
              private matDialogRef: MatDialogRef<EmployeeDeleteComponent>,
              private matDialog: MatDialog,
              private employeeService: EmployeeService,
              private router: Router){
    this.id = data.id;
    this.name = data.name;
  }

  ngOnInit(): void {
  }

  deleteEmployee() {
    this.employeeService.deleteEmployee(this.id).subscribe(
      ()=>{
        console.log('delete');
        this.router.navigateByUrl('/employee-list');
      },
      error => {
        console.log(error);
      }
    );

  }
}
