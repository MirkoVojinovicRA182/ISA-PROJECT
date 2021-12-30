import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { serverPort } from 'src/app/app.consts';
import { Administrator } from 'src/app/model/administrator';
import { RegistrationRequest } from 'src/app/model/registration-request';

@Injectable({
  providedIn: 'root'
})
export class UserRegistrationService {

  private _url = serverPort;

  constructor(private _http: HttpClient) { }

  getRegistrationRequests(): Observable<RegistrationRequest[]> {
    return this._http.get<RegistrationRequest[]>(this._url + 'registration/getRegistrationRequests/'); 
  }

  approveRegistration(request: RegistrationRequest) {
    return this._http.post<RegistrationRequest>(this._url + 'registration/approveRegistration/', request);
  }

  ejectRegistration(request: RegistrationRequest) {
    return this._http.post<RegistrationRequest>(this._url + 'registration/ejectRegistration/', request);
  }

  registerAdmin(newAdmin: Administrator){
    return this._http.post<Administrator>(this._url + 'registration/registerAdmin/', newAdmin);
  }
}
