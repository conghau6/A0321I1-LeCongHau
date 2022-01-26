import {Component, OnDestroy, OnInit} from '@angular/core';

@Component({
  selector: 'app-lifecycle-hook',
  templateUrl: './lifecycle-hook.component.html',
  styleUrls: ['./lifecycle-hook.component.css']
})
export class LifecycleHookComponent implements OnInit, OnDestroy {

  constructor() {
    console.log("constructor được gọi");
  }

  ngOnInit(): void {
    console.log("ngOnInit được gọi");
  }

  ngOnDestroy(): void {
    console.log("ngOnDestroy được gọi");
  }

}
