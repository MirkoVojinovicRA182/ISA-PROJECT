import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { serverPort } from 'src/app/app.consts';
import { Report } from 'src/app/model/report';
import { Reservation } from 'src/app/model/reservation';

@Injectable({
  providedIn: 'root'
})
export class ReservationsService {

  private _url = serverPort;

  constructor(private http: HttpClient) { }
  
  getReservations(instructorId: number): Observable<Reservation[]> {
    return this.http.get<Reservation[]>(this._url + 'reservation/getInstructorReservations/' + instructorId);
  }

  createAventureReservationReport(report: Report): Observable<Report>{
    return this.http.post<Report>(this._url + 'reservation/createAventureReservationReport/', report);
  }
}
