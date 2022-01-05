import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { serverPort } from 'src/app/app.consts';

@Injectable({
  providedIn: 'root'
})
export class UserSettingsService {
  private _url = serverPort;

  constructor(private http: HttpClient) { }

  public changePassword(userPasswordDTO: any){
    return this.http.post<any>(this._url + 'userProfile/updatePassword/', userPasswordDTO);
  }

  public createDeleteAccountRequest(deleteAccountDto: any): any{
    return this.http.post<any>(this._url + 'deleteAccountRequest/createRequest/', deleteAccountDto);
  }
}
