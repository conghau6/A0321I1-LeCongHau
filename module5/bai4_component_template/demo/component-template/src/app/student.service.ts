import { Injectable } from '@angular/core';
import {Student} from "../model/Student";

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  private _studentList:Student[] = [
    {name: "Nguyen Van A", gender: 0, point: 100},
    {name: "Nguyen Van B", gender: 1, point: 80},
    {name: "Nguyen Van C", gender: 2, point: 50},
    {name: "Nguyen Van D", gender: 0, point: 0},
  ];

  constructor() { }

  get studentList():Student[] {
    return this._studentList;
  }

  set studentList(value:Student[]){
    this._studentList = value;
  }

  save(student:Student){
    this._studentList.unshift(student);
  }

  getStudentByIndex(studentIndex: any) {
    return this._studentList[studentIndex];
  }
}
