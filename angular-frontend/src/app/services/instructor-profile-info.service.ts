import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { serverPort } from '../app.consts';
import { Instructor } from '../model/instructor';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class InstructorProfileInfoService {

  private _url = serverPort;

  constructor(private http: HttpClient) { }

  public getProfileInfo(instructorId: number): Observable<Instructor> {
    return this.http.get<Instructor>(this._url + 'entity/getInstructor/' + instructorId);
  }

  public changeProfileInfo(instructor: Instructor): Observable<Instructor> {
    return this.http.post<Instructor>(this._url + 'userProfile/updatePersonalInfo/', instructor);
  }
}
