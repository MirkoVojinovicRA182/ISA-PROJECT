import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { serverPort } from 'src/app/app.consts';
import { AdventureReservation } from 'src/app/model/adventure-reservation';
import { Report } from 'src/app/model/report';

@Injectable({
  providedIn: 'root'
})
export class ReservationsService {

  private _url = serverPort;

  constructor(private http: HttpClient) { }
  
  getReservations(instructorId: number): Observable<AdventureReservation[]> {
    return this.http.get<AdventureReservation[]>(this._url + 'reservation/getInstructorReservations/' + instructorId);
  }

  createAventureReservationReport(report: Report): Observable<Report>{
    return this.http.post<Report>(this._url + 'reservation/createAdventureReservationReport/', report);
  }

  createAdventureReservation(reservation: AdventureReservation): Observable<AdventureReservation>{
    return this.http.post<AdventureReservation>(this._url + 'reservation/adventureReservation/', reservation);
  }
}
