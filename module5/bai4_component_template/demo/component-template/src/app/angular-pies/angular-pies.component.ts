import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-angular-pies',
  templateUrl: './angular-pies.component.html',
  styleUrls: ['./angular-pies.component.css']
})
export class AngularPiesComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  dataInput:string = 'Tết đến nơi rồi mọi người ơi';
  inputNumber:number = 5.63;
  money:number = 9.87345634;
  today:Date = new Date();
}
