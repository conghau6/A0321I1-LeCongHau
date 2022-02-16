import {Component, Input, OnInit} from '@angular/core';
import {Article} from "../model/article";
@Component({
  selector: 'app-list-article',
  templateUrl: './list-article.component.html',
  styleUrls: ['./list-article.component.css']
})
export class ListArticleComponent implements OnInit {

  @Input() articleList:Article[];
  constructor() { }

  ngOnInit(): void {
  }

}
