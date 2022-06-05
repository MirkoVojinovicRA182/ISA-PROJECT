import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { serverPort } from 'src/app/app.consts';
import { Subscription } from 'src/app/model/subscription';

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  private _url = serverPort;

  constructor(private http: HttpClient) { }

  public getCottageOwnerById(id: number): Observable<any> {
    return this.http.get<any>(this._url + 'entity/getCottageOwner/' + id);
  }

  public cottageSubscribe(sub: Subscription) {
    return this.http.put<any>(this._url + 'client/cottageSubscribe', sub);
  }

  public cottageUnSubscribe(sub: Subscription) {
    return this.http.put<any>(this._url + 'client/cottageUnSubscribe', sub);
  }

  public userSubscribe(sub: Subscription) {
    return this.http.put<any>(this._url + 'client/userSubscribe', sub);
  }

  public userUnSubscribe(sub: Subscription) {
    return this.http.put<any>(this._url + 'client/userUnSubscribe', sub);
  }

  public adventureSubscribe(sub: Subscription) {
    return this.http.put<any>(this._url + 'client/adventureSubscribe', sub);
  }

  public adventureUnSubscribe(sub: Subscription) {
    return this.http.put<any>(this._url + 'client/adventureUnSubscribe', sub);
  }

  public shipSubscribe(sub: Subscription) {
    return this.http.put<any>(this._url + 'client/shipSubscribe', sub);
  }

  public shipUnSubscribe(sub: Subscription) {
    return this.http.put<any>(this._url + 'client/shipUnSubscribe', sub);
  }

  public isSubscribedToCottage(sub: Subscription): Observable<any> {
    return this.http.put<any>(this._url + 'client/isSubscribedToCottage/', sub);
  }

  public isSubscribedToAdventure(sub: Subscription): Observable<any> {
    return this.http.put<any>(this._url + 'client/isSubscribedToAdventure/', sub);
  }

  public isSubscribedToShip(sub: Subscription): Observable<any> {
    return this.http.put<any>(this._url + 'client/isSubscribedToShip/', sub);
  }

  public isSubscribedToUser(sub: Subscription): Observable<any> {
    return this.http.put<any>(this._url + 'client/isSubscribedToUser/', sub);
  }
}
