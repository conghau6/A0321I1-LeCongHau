import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-hackernews-app',
  templateUrl: './hackernews-app.component.html',
  styleUrls: ['./hackernews-app.component.scss']
})
export class HackernewsAppComponent {
  article = {
    title: 'The Evolution of Async JavaScript: From Callbacks, to Promises, to Async/Await',
    url: 'https://medium.freecodecamp.org/the-evolution-of-async-javascript-from-callbacks-to-promises-to-async-await-e73b047f2f40'
  };

  updateArticle(title, url) {
    this.article.title = title.value;
    this.article.url = url.value;
  }
}
