import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { serverPort } from 'src/app/app.consts';

@Injectable({
  providedIn: 'root'
})
export class ShipsService {

  private _url = serverPort;

  constructor(private http: HttpClient) { }

  getAllShips(): Observable<any>{
    return this.http.get<any>(this._url + 'entity/getAllShips/');
  }
}
