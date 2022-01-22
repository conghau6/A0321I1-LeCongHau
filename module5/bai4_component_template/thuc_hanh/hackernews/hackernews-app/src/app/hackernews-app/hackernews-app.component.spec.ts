import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HackernewsAppComponent } from './hackernews-app.component';

describe('HackernewsAppComponent', () => {
  let component: HackernewsAppComponent;
  let fixture: ComponentFixture<HackernewsAppComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HackernewsAppComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HackernewsAppComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
