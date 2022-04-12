import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { serverPort } from 'src/app/app.consts';
import { Administrator } from 'src/app/model/administrator';
import { EjectRegistrationRequest } from 'src/app/model/eject-registration-request';
import { RegistrationRequest } from 'src/app/model/registration-request';
import { User } from 'src/app/model/user';

@Injectable({
  providedIn: 'root'
})
export class UserRegistrationService {

  private _url = serverPort;

  constructor(private _http: HttpClient) { }

  getRegistrationRequests(): Observable<RegistrationRequest[]> {
    return this._http.get<RegistrationRequest[]>(this._url + 'registration/getRegistrationRequests/'); 
  }

  sendRegistrationRequest(registrationRequest: RegistrationRequest){
    return this._http.post<RegistrationRequest>(this._url + 'registration/createRegistrationRequest', registrationRequest);
  }

  approveRegistration(request: RegistrationRequest) {
    return this._http.post<RegistrationRequest>(this._url + 'registration/approveRegistration/', request);
  }

  ejectRegistration(ejectRegistrationRequest: EjectRegistrationRequest) {
    return this._http.post<RegistrationRequest>(this._url + 'registration/ejectRegistration/', ejectRegistrationRequest);
  }

  registerAdmin(newAdmin: Administrator){
    return this._http.post<Administrator>(this._url + 'registration/registerAdmin/', newAdmin);
  }

  getUsers(){
    return this._http.get<User[]>(this._url + 'users/getUsers/'); 
  }

  deleteUser(user: User){
    return this._http.delete(this._url + 'users/deleteUser?userId=' + user.userId + '&userType=' + user.userType);
  }

}
