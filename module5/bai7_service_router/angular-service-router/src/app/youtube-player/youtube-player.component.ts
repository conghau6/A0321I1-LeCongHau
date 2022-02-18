import { Component, OnInit } from '@angular/core';
import {Subscription} from "rxjs";
import {YoutubeService} from "../youtube.service";
import {ActivatedRoute, ParamMap} from "@angular/router";
import {DomSanitizer} from "@angular/platform-browser";

@Component({
  selector: 'app-youtube-player',
  templateUrl: './youtube-player.component.html',
  styleUrls: ['./youtube-player.component.css']
})
export class YoutubePlayerComponent implements OnInit {

  song: any;
  sub: Subscription;

  constructor(private _youtubeService: YoutubeService,
              private _activeRouter: ActivatedRoute,
              private _domSanitizer: DomSanitizer) { }

  ngOnInit(): void {
    this.sub = this._activeRouter.paramMap.subscribe((paramMap: ParamMap) => {
      const id = paramMap.get('id');
      this.song = this._youtubeService.find(id);
    })
  }

  getSrc(){
    console.log(this.song);
    const url = 'https://www.youtube.com/embed/' + this.song.id;
    return this._domSanitizer.bypassSecurityTrustResourceUrl(url);
  }

  ngOnDestroy(){
    this.sub.unsubscribe();
  }
}
