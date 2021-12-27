import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { serverPort } from 'src/app/app.consts';
import { Instructor } from 'src/app/model/instructor';

@Injectable({
  providedIn: 'root'
})
export class InstructorHomePageService {

  private _url = serverPort;

  constructor(private http: HttpClient) { }

  public getProfileInfo(instructorId: number): Observable<Instructor> {
    return this.http.get<Instructor>(this._url + 'entity/getInstructor/' + instructorId);
  }

  public changeProfileInfo(instructor: Instructor): Observable<Instructor> {
    return this.http.post<Instructor>(this._url + 'userProfile/updatePersonalInfo/', instructor,);
  }
}
