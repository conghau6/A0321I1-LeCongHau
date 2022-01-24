import {Component, EventEmitter, Input, Output} from '@angular/core';
import {Article} from "../model/article";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  message: string = '';
  clickMe(){
    this.message = '';
  }
  article = {
    title: '',
    url: ''
  } as Article;

  articleList:Article[] = [
    {title: "Google", url: "google.com"},
    {title: "Facebook", url: "facebook.com"},
    {title: "Tiktok", url: "tiktok.com"}
  ];

  addArticle(title, url):void {
    console.log(title.value,url.value);
    this.article.title = title.value;
    this.article.url = url.value;
    this.articleList.push(this.article);
  }

}
