import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { ListComponent } from './components/list/list.component';
import { EditComponent } from './components/edit/edit.component';
import { AddComponent } from './components/add/add.component';
import { DeleteComponent } from './components/delete/delete.component';
import {MatDialogModule} from "@angular/material/dialog";
import {NgxPaginationModule} from "ngx-pagination";
import {MatButtonModule} from "@angular/material/button";
import {CommonModule} from "@angular/common";
import {ReactiveFormsModule} from "@angular/forms";


const routes: Routes = [
  {path: 'list', component: ListComponent},
  {path: 'edit/:id', component: EditComponent},
  {path: '**', component: PageNotFoundComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes), MatDialogModule, NgxPaginationModule, MatButtonModule, CommonModule, ReactiveFormsModule],
  exports: [RouterModule],
  declarations: [HomeComponent, PageNotFoundComponent, ListComponent, EditComponent, AddComponent, DeleteComponent]
})
export class AppRoutingModule { }
