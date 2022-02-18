import { Component, OnInit } from '@angular/core';
import {DateUtilService} from "../date-util.service";

@Component({
  selector: 'app-timelines',
  templateUrl: './timelines.component.html',
  styleUrls: ['./timelines.component.css']
})
export class TimelinesComponent implements OnInit {

  output = '';

  constructor(private _dateUtilService: DateUtilService) { }

  ngOnInit(): void {
  }

  onChange(value) {
    this.output = this._dateUtilService.getDiffToNow(value);
  }
}
