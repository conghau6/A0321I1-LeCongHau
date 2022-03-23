import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {Router, RouterModule, Routes} from "@angular/router";
import { HomeComponent } from './components/home/home.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { EmployeeListComponent } from './components/employees/employee-list/employee-list.component';
import {NgxPaginationModule} from 'ngx-pagination';
import {ReactiveFormsModule} from "@angular/forms";
import { EmployeeEditComponent } from './components/employees/employee-edit/employee-edit.component';
import { EmployeeAddComponent } from './components/employees/employee-add/employee-add.component';
import { EmployeeDeleteComponent } from './components/employees/employee-delete/employee-delete.component';
import {MatDialogModule} from "@angular/material/dialog";

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'employee-add', component: EmployeeAddComponent},
  {path: 'employee-list', component: EmployeeListComponent},
  {path: 'employee-edit/:id', component: EmployeeEditComponent},
  {path: '**', component: PageNotFoundComponent},
];

@NgModule({
  declarations: [HomeComponent, PageNotFoundComponent, EmployeeListComponent, EmployeeEditComponent, EmployeeAddComponent, EmployeeDeleteComponent],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes),
    NgxPaginationModule,
    ReactiveFormsModule,
    MatDialogModule
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
