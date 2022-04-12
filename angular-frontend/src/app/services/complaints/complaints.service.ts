import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { serverPort } from 'src/app/app.consts';
import { ComplaintAnswer } from 'src/app/model/complaint-answer';
import { InstructorComplaint } from 'src/app/model/instructor-complaint';
import { OwnerComplaint } from 'src/app/model/owner-complaint';

@Injectable({
  providedIn: 'root'
})
export class ComplaintsService {

  private _url = serverPort;

  constructor(private http: HttpClient) { }

  public getInstructorComplaints(): Observable<InstructorComplaint[]> {
    return this.http.get<InstructorComplaint[]>(this._url + 'complaint/getInstructorComplaints');
  }

  public getShipsComplaints(): Observable<OwnerComplaint[]> {
    return this.http.get<OwnerComplaint[]>(this._url + 'complaint/getShipsComplaints');
  }

  public getCottagesComplaints(): Observable<OwnerComplaint[]> {
    return this.http.get<OwnerComplaint[]>(this._url + 'complaint/getCottagesComplaints');
  }

  public sendComplaintAnswer(answer: ComplaintAnswer){
    return this.http.post<ComplaintAnswer>(this._url + 'complaint/sendComplaintAnswer', answer);
  }
}
