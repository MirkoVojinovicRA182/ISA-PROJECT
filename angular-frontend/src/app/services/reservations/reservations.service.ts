import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { serverPort } from 'src/app/app.consts';
import { Reservation } from 'src/app/model/reservation';

@Injectable({
  providedIn: 'root'
})
export class ReservationsService {

  private _url = serverPort;

  constructor(private http: HttpClient) { }
  
  getReservations(instructorId: number): Observable<Reservation> {
    return this.http.get<Reservation>(this._url + 'reservation/getInstructorAdventures/' + instructorId);
  }
}
