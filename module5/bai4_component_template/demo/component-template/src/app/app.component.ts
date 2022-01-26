import { Component } from '@angular/core';
import {Student} from "../model/Student";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'component-template';
  isDisplay:boolean = true;

  studentList:Student[] = [
    {name:"Nguyen Van A", gender: 0, point: 100},
    {name:"Nguyen Van B", gender: 1, point: 80},
    {name:"Nguyen Van C", gender: 2, point: 50},
    {name:"Nguyen Van D", gender: 0, point: 0},
  ];

  onToggle() {
    this.isDisplay = !this.isDisplay;
  }
}
