import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class XeService {
  public API: string = "http://localhost:3000/xe";
  public API_XE: string = 'http://localhost:3000/diaDiem';
  constructor(public http: HttpClient) { }

  getAllXe():Observable<any>{
    return this.http.get(this.API);
  }

  getXeById(id: any): Observable<any>{
    return this.http.get(`${this.API}/${id}`);
  }

  getAllDiaDiem(): Observable<any> {
    return this.http.get(this.API_XE);
  }

  updateXe(xe: any): Observable<any> {
    return this.http.put(`${this.API}/${xe.id}`,xe);
  }

  deleteXe(id: any):Observable<any> {
    return this.http.delete(`${this.API}/${id}`);
  }
}
