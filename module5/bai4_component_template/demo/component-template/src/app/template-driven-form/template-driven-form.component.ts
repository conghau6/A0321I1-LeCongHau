import { Component, OnInit } from '@angular/core';
import {Student} from "../../model/Student";
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-template-driven-form',
  templateUrl: './template-driven-form.component.html',
  styleUrls: ['./template-driven-form.component.css']
})
export class TemplateDrivenFormComponent implements OnInit {

  student:Student = {name:"Nguyen Van A",point: 0, gender: 1};

  constructor() { }

  ngOnInit(): void {
  }

  onSubmitForm(studentForm: NgForm) {
    console.log(studentForm);
    console.log(this.student);
  }
}
