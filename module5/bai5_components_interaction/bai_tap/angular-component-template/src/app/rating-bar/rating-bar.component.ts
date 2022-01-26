import {Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges} from '@angular/core';
import index from "@angular/cli/lib/cli";
interface IRatingUnit {
  value: number;
  active: boolean;
}
@Component({
  selector: 'app-rating-bar',
  templateUrl: './rating-bar.component.html',
  styleUrls: ['./rating-bar.component.css']
})
export class RatingBarComponent implements OnInit, OnChanges {

  @Input() max = 10;
  @Output() ratingValue = 10;
  @Input() showRatingValue = true;
  @Output()
  rateChange = new EventEmitter<number>();
  ratingUnits: Array<IRatingUnit> = [];

  constructor() {
  }

  ngOnChanges(changes: SimpleChanges): void {
    if('max' in changes){
      let max = changes.max.currentValue;
      max = typeof max === 'undefined' ? 10 : 'max';
      this.max = max;
    }
  }

  calculate(max,ratingValue){
    this.ratingUnits = Array.from({length: max},
      (_, index) =>({
        value: index + 1,
        active: index < ratingValue
      }));
  }

  ngOnInit(): void {
    this.calculate(this.max, this.ratingValue);
  }

  select(index){
    this.ratingValue = index + 1;
    this.ratingUnits.forEach((item, index) => item.active = index < this.ratingValue);
    this.rateChange.emit(this.ratingValue);
  }

  enter(index) {
    this.ratingUnits.forEach((item, idx) => item.active = idx <= index);
  }
  reset() {
    this.ratingUnits.forEach((item, idx) => item.active = idx < this.ratingValue);
  }

}
