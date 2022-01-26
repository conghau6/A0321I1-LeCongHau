import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AngularPiesComponent } from './angular-pies.component';

describe('AngularPiesComponent', () => {
  let component: AngularPiesComponent;
  let fixture: ComponentFixture<AngularPiesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AngularPiesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AngularPiesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
