import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-reactive-form',
  templateUrl: './reactive-form.component.html',
  styleUrls: ['./reactive-form.component.css']
})
export class ReactiveFormComponent implements OnInit {

  rfStudent:FormGroup;

  constructor(private _formBuilder: FormBuilder) { }

  ngOnInit(): void {
  //  sữ dụng FormGroup
  //   this.rfStudent = new FormGroup({
  //     studentName: new FormControl("Hoa"),
  //     studentGender: new FormControl(2),
  //     studentPoint: new FormControl(90),
  //   })

    // sữ dụng FormBuilder
    this.rfStudent = this._formBuilder.group({
      studentName: ["Hoa",[Validators.required, Validators.minLength(5)]],
      studentGender: [2],
      studentPoint: [100],
    })
  }

  onSubmit() {
    console.log(this.rfStudent);
    console.log(this.rfStudent.value);
  }
}
