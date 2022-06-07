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

  getSystemSallary(fromDate: Date, toDate: Date) {
    let data = {
      fromDate: fromDate,
      toDate: toDate
    }

    return this.http.post(this._url + 'reservation/sumSystemSallary/', data);
  }

  defineSystemSallary(sallary: number){
    return this.http.post(this._url + 'reservation/defineSystemSallary/'+ sallary, sallary);
  }

  getReservationStatistics(dateRange: any){
    return this.http.post(this._url + 'reservation/getReservationStatistics', dateRange);
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

  isCottageFree(params: any): Observable<any> {
    return this.http.post<any>(this._url + 'reservation/isCottageFree', params);
  }
  
  isShipFree(params: any): Observable<any> {
    return this.http.post<any>(this._url + 'reservation/isShipFree', params);
  }

  isAdventureFree(params: any): Observable<any> {
    return this.http.post<any>(this._url + 'reservation/isAdventureFree', params);
  }

  bookCottage(params: any): Observable<any> {
    return this.http.post<any>(this._url + 'reservation/bookCottage', params);
  }

  bookShip(params: any): Observable<any> {
    return this.http.post<any>(this._url + 'reservation/bookShip', params);
  }

  bookAdventure(params: any): Observable<any> {
    return this.http.post<any>(this._url + 'reservation/bookAdventure', params);
  }

  getCottageHistoryReservationByClientId(clientId: number): Observable<any[]>{
    return this.http.get<ActionAdventure[]>(this._url + 'reservation/getCottageHistoryReservations/' + clientId);
  }

  getCottageCurrentReservationByClientId(clientId: number): Observable<any[]>{
    return this.http.get<ActionAdventure[]>(this._url + 'reservation/getCottageCurrentReservations/' + clientId);
  }

  getShipHistoryReservationByClientId(clientId: number): Observable<any[]>{
    return this.http.get<ActionAdventure[]>(this._url + 'reservation/getShipHistoryReservations/' + clientId);
  }

  getShipCurrentReservationByClientId(clientId: number): Observable<any[]>{
    return this.http.get<ActionAdventure[]>(this._url + 'reservation/getShipCurrentReservations/' + clientId);
  }

  getAdventureHistoryReservationByClientId(clientId: number): Observable<any[]>{
    return this.http.get<ActionAdventure[]>(this._url + 'reservation/getAdventureHistoryReservations/' + clientId);
  }

  getAdventureCurrentReservationByClientId(clientId: number): Observable<any[]>{
    return this.http.get<ActionAdventure[]>(this._url + 'reservation/getAdventureCurrentReservations/' + clientId);
  }

  rateAdventure(params: any): Observable<any> {
    return this.http.post<any>(this._url + 'users/rateAdventure', params);
  }

  rateShip(params: any): Observable<any> {
    return this.http.post<any>(this._url + 'users/rateShip', params);
  }

  rateCottage(params: any): Observable<any> {
    return this.http.post<any>(this._url + 'users/rateCottage', params);
  }

  cancelCottageReservation(id: any){
    return this.http.delete(this._url + 'reservation/cancelCottageReservation/' + id);
  }

  cancelShipReservation(id: any): Observable<any> {
    return this.http.post<any>(this._url + 'reservation/cancelShipReservation', id);
  }

  cancelAdventureReservation(id: any): Observable<any> {
    return this.http.post<any>(this._url + 'reservation/cancelAdventureReservation', id);
  }

  complaintCottage(params: any): Observable<any> {
    return this.http.post<any>(this._url + 'users/complaintCottage', params);
  }

  complaintShip(params: any): Observable<any> {
    return this.http.post<any>(this._url + 'users/complaintShip', params);
  }

  complaintAdventure(params: any): Observable<any> {
    return this.http.post<any>(this._url + 'users/complaintAdventure', params);
  }
  
}
