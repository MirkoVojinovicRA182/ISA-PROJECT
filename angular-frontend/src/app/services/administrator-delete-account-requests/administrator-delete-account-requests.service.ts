import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { serverPort } from 'src/app/app.consts';
import { DeleteAccountRequest } from 'src/app/model/delete-account-request';

@Injectable({
  providedIn: 'root'
})
export class AdministratorDeleteAccountRequestsService {

  private _url = serverPort;

  constructor(private http: HttpClient) { }

  getRequests(): Observable<DeleteAccountRequest[]>{
    return this.http.get<DeleteAccountRequest[]>(this._url + 'deleteAccountRequest/getRequests/');
  }

  deleteAccount(deleteAccountRequest: DeleteAccountRequest){
    return this.http.delete(this._url + 'deleteAccountRequest/deleteAccount?userId=' + deleteAccountRequest.userId + '&requestId=' + deleteAccountRequest.id);
  }

  ejectRequest(requestId: number){
    return this.http.delete(this._url + 'deleteAccountRequest/ejectDeleteRequest/' + requestId);
  }
}
