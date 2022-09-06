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

  deleteCottage(id: any){
    return this.http.delete(this._url + 'cottage/deleteCottage/' + id);
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

  addAvailability(data: any){
    return this.http.post<any>(this._url + 'cottage/addCottageAvailability' , data);
  }

  removeAvailability(data: any){
    return this.http.delete(this._url + 'cottage/deleteCottageAvailability/' + data);
  }

  getAllUsersReservated(cottageOwnerId: number){
    return this.http.get(this._url + 'cottage/addUsersReservated/' + cottageOwnerId);
  }

  reservateCottage(reservation: any){
    return this.http.post(this._url + "reservation/cottageReservation", reservation);
  }

  createAction(action: any){
    return this.http.post(this._url + "cottage/createAction", action);
  }

  getReservations(cottageId: number){
    return this.http.get<any>(this._url + "cottage/reservations/" + cottageId);
  }

  createReport(report: any){
    return this.http.post(this._url + "cottage/createReport", report);
  }

}
