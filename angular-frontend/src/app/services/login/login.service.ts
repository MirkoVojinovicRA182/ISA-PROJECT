import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { serverPort } from 'src/app/app.consts';
import { LoginUser } from 'src/app/model/login-user';
import { User } from 'src/app/model/user';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private _url = serverPort

  constructor(private _http: HttpClient) { }

  getUser(loginUser: LoginUser): Observable<any>{
    const params = new HttpParams({
      fromObject: {
        username: loginUser.username,
        password: loginUser.password
      }
    })
    return this._http.get<User>(this._url + 'login/getUser', {params: params});
  }

  login(loginUser: LoginUser){
    let data ={
      username: loginUser.username,
      password: loginUser.password
    }
    return this._http.post<any>(this._url + 'login/login',  data);
  }
}
