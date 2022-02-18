import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class YoutubeService {

  playList = [
    {id: 'sBsK08463zw', song: 'Nhạc Chill TikTok - Thay Lòng, Vui Lắm Nha, Yêu Là Cưới | Nhạc Lofi Chill Hay Nhất 2022'},
    {id: 'HBYirj2c_jw', song: 'Deadpool 2 - Take on Me'},
    {id: 'N6O2ncUKvlg', song: 'Nelly - Just A Dream'},
    {id: 'uelHwf8o7_U', song: 'Eminem - Love The Way You Lie ft. Rihanna'},
    {id: 'WpYeekQkAdc', song: 'The Black Eyed Peas - Where Is The Love?'}
  ];

  constructor() { }

  find(id: string){
    return this.playList.find(item => item.id === id);
  }
}
