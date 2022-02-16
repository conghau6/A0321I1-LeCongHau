import { NgModule } from '@angular/core';
import {MatButtonModule} from "@angular/material/button";

const MaterialComponent = [
  MatButtonModule
];

@NgModule({
  imports: [MaterialComponent],
  exports: [MaterialComponent]
})
export class MaterialModule { }
