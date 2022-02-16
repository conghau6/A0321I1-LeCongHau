import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';import { LifecycleHookComponent } from './lifecycle-hook/lifecycle-hook.component';
import { AngularPiesComponent } from './angular-pies/angular-pies.component';
import { StudentCreateComponent } from './student-create/student-create.component';
import { StudentDetailComponent } from './student-detail/student-detail.component';
import { TemplateDrivenFormComponent } from './template-driven-form/template-driven-form.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { ReactiveFormComponent } from './reactive-form/reactive-form.component';
import { StudentListComponent } from './student-list/student-list.component';

@NgModule({
  declarations: [
    AppComponent,
    LifecycleHookComponent,
    AngularPiesComponent,
    StudentCreateComponent,
    StudentDetailComponent,
    TemplateDrivenFormComponent,
    ReactiveFormComponent,
    StudentListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
