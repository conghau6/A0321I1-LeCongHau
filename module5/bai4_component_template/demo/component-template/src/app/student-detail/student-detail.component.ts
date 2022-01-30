import {Component, Input, OnInit} from '@angular/core';
import {Student} from "../../model/Student";

@Component({
  selector: 'app-student-detail',
  templateUrl: './student-detail.component.html',
  styleUrls: ['./student-detail.component.css']
})
export class StudentDetailComponent implements OnInit {

  @Input() studentDetail:Student | undefined;

  constructor() { }

  ngOnInit(): void {
  }

}
