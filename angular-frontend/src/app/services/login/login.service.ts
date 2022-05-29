import {HttpClient, HttpHeaders, HttpRequest, HttpResponse, HttpParams} from '@angular/common/http';
import {Injectable} from '@angular/core';
import { Router } from '@angular/router';
import {Observable, pipe} from 'rxjs';
import {catchError, filter, map} from 'rxjs/operators';
import { serverPort } from 'src/app/app.consts';
import { LoginUser } from 'src/app/model/login-user';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  currentUser: any;
  private _url = serverPort
  private access_token = null;
  private loginHeaders = new HttpHeaders({
    'Accept': 'application/json',
    'Content-Type': 'application/json'
  });

  constructor(private _http: HttpClient, private router: Router) { }

  getUser(user: LoginUser): Observable<any>{
    // const body = `username=${user.username}&password=${user.password}`;
    const body = {
      'username': user.username,
      'password': user.password
    };
    
    return this.request(this._url + 'login/', JSON.stringify(body), 'POST', this.loginHeaders)
      .pipe(map((res) => {
        console.log('Login success');
        this.access_token = res.accessToken;
        localStorage.setItem("jwt", res.accessToken)
        this.router.navigate(['admin'])
      }));
  }
  private request(path: string, body: any, method: string, custemHeaders?: HttpHeaders): Observable<any> {
    const req = new HttpRequest(method, path, body, {
      headers: custemHeaders || this.loginHeaders,
    });

    return this._http.request(req).pipe(filter(response => response instanceof HttpResponse))
      .pipe(catchError(error => this.checkError(error)));
  }

  private checkError(error: any): any {
    throw error;
  }

  login(user: any): Observable<any> {
    const loginHeaders = new HttpHeaders({
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    });
    // const body = `username=${user.username}&password=${user.password}`;
    const body = {
      'username': user.username,
      'password': user.password
    };
    return this.post(this._url + 'login/', JSON.stringify(body), loginHeaders)
  }

  post(path: string, body: any, customHeaders?: HttpHeaders): Observable<any> {
    return this.request(path, body, 'POST', customHeaders);
  }

  getMyInfo(username: string) {
    return this._http.get<any>(this._url + 'login/whoami/' + username)
    .pipe(map(user => {
      this.currentUser = user;
      return user;
    }));
  }

  get(path: string, args?: any): Observable<any> {
    const options = {
      headers: this.loginHeaders,
    };

    return this._http.get(path, options)
      .pipe(catchError(this.checkError.bind(this)));
  }

  login(loginUser: LoginUser){
    let data ={
      username: loginUser.username,
      password: loginUser.password
    }
    return this._http.post<any>(this._url + 'login/login',  data);
  }
}
