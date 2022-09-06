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

  getUsersShips(userId: number){
    return this.http.get<any>(this._url + 'ship/getUserShips/' + userId);
  }

  createShip(ship: any){
    return this.http.post<any>(this._url + 'ship/createShip', ship)
  }

  deleteShip(shipId: number){
    return this.http.delete<any>(this._url + 'ship/deleteShip/' + shipId)
  }

  updateShip(ship: any){
    return this.http.put<any>(this._url + 'ship/updateShip', ship)
  }

  addImages(image: any){
    return this.http.post<any>(this._url + 'ship/addImage/', image)
  }

  removeImage(image: any){
    return this.http.put<any>(this._url + 'ship/deleteImage/', image)
  }
}
