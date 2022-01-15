import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { serverPort } from 'src/app/app.consts';
import { ActionAdventure } from 'src/app/model/action-adventure';
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

  createAdventureReservationReport(report: Report): Observable<Report>{
    return this.http.post<Report>(this._url + 'reservation/createAdventureReservationReport/', report);
  }

  createAdventureReservation(reservation: AdventureReservation){
    return this.http.post(this._url + 'reservation/adventureReservation/', reservation, {responseType: 'text'}).pipe(
      catchError(this.handleError)
    )
  }

  getAdventureActionsByAdventureId(adventureId: number): Observable<ActionAdventure[]>{
    return this.http.get<ActionAdventure[]>(this._url + 'action/getByAdventureId/' + adventureId);
  }

  createAdventureAction(action: ActionAdventure){
    return this.http.post(this._url + 'action/createAdventureAction/', action, {responseType: 'text'}).pipe(
      catchError(this.handleError))
  }

  getInstructorSallary(fromDate: Date, toDate:Date, instructorId: number): Observable<any>{

    let data = {
      fromDate: fromDate,
      toDate: toDate,
      instructorId: instructorId
    }

    return this.http.post(this._url + 'reservation/generateInstructorSallary/', data);

  }

  private handleError(err: HttpErrorResponse): Observable<never> {
    // in a real world app, we may send the server to some remote logging infrastructure
    // instead of just logging it to the console
    let errorMessage = '';
    if (err.error instanceof ErrorEvent) {
      // A client-side or network error occurred. Handle it accordingly.
      errorMessage = `An error occurred: ${err.error.message}`;
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong,
      errorMessage = `Server returned code: ${err.status}, error message is: ${err.message}`;
    }
    console.error(errorMessage);
    return throwError(() => errorMessage);
  }

}
