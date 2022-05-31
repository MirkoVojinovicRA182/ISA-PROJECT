import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { serverPort } from 'src/app/app.consts';
import { Cottage } from 'src/app/model/cottage';

@Injectable({
  providedIn: 'root'
})
export class CottagesService {

  private _url = serverPort;

  constructor(private http: HttpClient) { }

  getUserCottages(username: string): Observable<Cottage[]>{
    return this.http.get<Cottage[]>(this._url + 'cottage/cottageOwnerCottages/' + username);
  }

  getCottageById(cottageId: number): Observable<Cottage[]>{
    return this.http.get<Cottage[]>(this._url + 'cottage/getCottage/' + cottageId);
  }
}
