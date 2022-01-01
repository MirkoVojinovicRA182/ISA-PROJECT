import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { serverPort } from 'src/app/app.consts';
import { User } from 'src/app/model/user';

@Injectable({
  providedIn: 'root'
})
export class UserProfileService {

  private _url = serverPort;

  constructor(private http: HttpClient) { }

  
  getAdminProfileInfo(id: number): Observable<User> {
    return this.http.get<User>(this._url + 'entity/getAdministrator/' + id);
  }

  public changeProfileInfo(loggedUser: User): Observable<User> {
    return this.http.post<User>(this._url + 'userProfile/updatePersonalInfo/', loggedUser);
  }
}
