import {Component, EventEmitter, Input, Output} from '@angular/core';
import {Article} from "../model/article";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'hackernews';

  article = {
    title: 'The Evolution of Async JavaScript: From Callbacks, to Promises, to Async/Await',
    url: 'https://medium.freecodecamp.org/the-evolution-of-async-javascript-from-callbacks-to-promises-to-async-await-e73b047f2f40'
  };

  articleList:Article[] = [
    {title: "Lê Công Hậu", url: "fb.com/conghau6"},
    {title: "Lê Công Hậu1", url: "fb.com/conghau6"},
    {title: "Lê Công Hậu2", url: "fb.com/conghau6"},
    {title: "Lê Công Hậu3", url: "fb.com/conghau6"},
  ];

  addArticle(title, url):void {
    console.log(title,url);
    this.article.title = title.value;
    this.article.url = url.value;
    this.articleList.push(this.article);
  }

}
