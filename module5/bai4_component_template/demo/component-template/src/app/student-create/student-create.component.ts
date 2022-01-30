import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Student} from "../../model/Student";

@Component({
  selector: 'app-student-create',
  templateUrl: './student-create.component.html',
  styleUrls: ['./student-create.component.css']
})
export class StudentCreateComponent implements OnInit {

  @Output() onCreate = new EventEmitter<Student>();

  student:Student | undefined;

  constructor() { }

  ngOnInit(): void {
  }

  createStudent(name: string, gender: string, point: string){
    this.student = {name: name, gender: parseInt(gender), point: parseInt(point)};
    console.log(this.student);

    this.onCreate.emit(this.student);
  }

}
