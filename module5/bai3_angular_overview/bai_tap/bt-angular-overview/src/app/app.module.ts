import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CalculatorComponent } from './calculator/calculator.component';
import { ColorPickerComponent } from './color-picker/color-picker.component';
import { HackernewsAppComponent } from '../../../../../bai4_component_template/thuc_hanh/hackernews/hackernews-app/src/app/hackernews-app/hackernews-app.component';

@NgModule({
  declarations: [
    AppComponent,
    CalculatorComponent,
    ColorPickerComponent,
    HackernewsAppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  exports: [
    HackernewsAppComponent
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
