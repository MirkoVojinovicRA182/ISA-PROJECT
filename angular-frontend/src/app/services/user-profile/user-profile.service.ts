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
    return this.http.put<User>(this._url + 'userProfile/updatePersonalInfo/', loggedUser);
  }

  getClient(clientUsername: string){
    return this.http.get<User>(this._url + 'users/getClient/' + clientUsername);
  }

  getCottageOwner(cottageOwnerUsername: string){
    return this.http.get<User>(this._url + 'users/getCottageOwner/' + cottageOwnerUsername);
  }

  getCottageOwnerById(id: any){
    return this.http.get<any>(this._url + 'entity/getCottageOwner/' + id);
  }

  getShipOwner(id: string){
    return this.http.get<User>(this._url + 'entity/getShipOwner/' + id);
  }

  updateCottageOwner(cottageOwner: any){
    return this.http.put<any>(this._url + 'users/updateCottageOwner' , cottageOwner);
  }

  updatePassword(data: any){
    return this.http.put<any>(this._url + 'userProfile/updatePassword' , data);
  }
}
