import {Component, Input, OnInit} from '@angular/core';
import {Student} from "../../model/Student";
import {ActivatedRoute} from "@angular/router";
import {StudentService} from "../student.service";

@Component({
  selector: 'app-student-detail',
  templateUrl: './student-detail.component.html',
  styleUrls: ['./student-detail.component.css']
})
export class StudentDetailComponent implements OnInit {

  // @Input() studentDetail:Student | undefined;
  studentDetail:Student | undefined;

  constructor(private _activeRouter:ActivatedRoute,
              private _studentService: StudentService) { }

  ngOnInit(): void {
    let studentIndex = this._activeRouter.snapshot.params['index'];
    console.log(studentIndex);
    this.studentDetail = this._studentService.getStudentByIndex(studentIndex);
  }

}
