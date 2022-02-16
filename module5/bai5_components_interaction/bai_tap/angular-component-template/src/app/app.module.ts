import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RatingBarComponent } from './rating-bar/rating-bar.component';
import { CountdownTimerComponent } from './countdown-timer/countdown-timer.component';
import { HackernewsComponent } from './hackernews/hackernews.component';
import { LikeComponent } from './like/like.component';
import { ListArticleComponent } from './list-article/list-article.component';

@NgModule({
  declarations: [
    AppComponent,
    RatingBarComponent,
    CountdownTimerComponent,
    HackernewsComponent,
    LikeComponent,
    ListArticleComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
