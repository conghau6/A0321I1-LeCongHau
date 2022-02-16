import {Component, OnInit} from '@angular/core';
import {Student} from "../model/Student";
import {StudentService} from "./student.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'component-template';
  isDisplay:boolean = true;

  student: Student | undefined;
  studentList:Student[] | undefined;

  constructor(private _studentService:StudentService) {
  }

  ngOnInit():void{
    this.studentList = this._studentService.studentList;
  }

  onToggle() {
    this.isDisplay = !this.isDisplay;
  }

  showDetail(item: Student){
    this.student = item;
  }

  getNewStudent(value: Student){
    this._studentService.save(value);
  }}
