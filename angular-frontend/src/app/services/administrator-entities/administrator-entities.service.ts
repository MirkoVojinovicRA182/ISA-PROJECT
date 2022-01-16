import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { serverPort } from 'src/app/app.consts';

@Injectable({
  providedIn: 'root'
})
export class AdministratorEntitiesService {

  private _url = serverPort;

  constructor(private http: HttpClient) { }

  public getAllCottages(): Observable<any> {
    return this.http.get<any>(this._url + 'entity/getAllCottages/');
  }

  public deleteCottage(cottageId: number){
    return this.http.delete(this._url + 'entity/deleteCottage/' + cottageId);
  }
}
