import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { serverPort } from '../../app.consts';
import { Instructor } from '../../model/instructor';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class InstructorProfileInfoService {

  private _url = serverPort;

  constructor(private _http: HttpClient) { }

  public changeProfileInfo(instructor: Instructor): Observable<Instructor> {
    return this._http.post<Instructor>(this._url + 'userProfile/updatePersonalInfo/', instructor,);
  }
}
