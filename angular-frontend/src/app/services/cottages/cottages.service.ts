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

  getUserCottages(username: string){
    return this.http.get<any>(this._url + 'cottage/cottageOwnerCottages/' + username);
  }

  getCottageById(cottageId: number): Observable<Cottage[]>{
    return this.http.get<Cottage[]>(this._url + 'cottage/getCottage/' + cottageId);
  }

  addNewCottage(cottage: any){
    return this.http.post<any>(this._url + 'cottage/createCottage' , cottage);
  }

  updateCottage(cottage: any){
    return this.http.put<any>(this._url + 'cottage/updateCottage' , cottage);
  }
  
  getAllCottages(): Observable<Cottage[]>{
    return this.http.get<Cottage[]>(this._url + 'entity/getAllCottages/');
  }

  addRoom(data: any){
    return this.http.put<any>(this._url + 'cottage/addRoom' , data);
  }

  addImages(data: any){
    return this.http.put<any>(this._url + 'cottage/addImage' , data);
  }

  removeImage(data: any){
    return this.http.put<any>(this._url + 'cottage/removeImage' , data);
  }
}
