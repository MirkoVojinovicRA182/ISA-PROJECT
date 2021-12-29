import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { serverPort } from 'src/app/app.consts';
import { InstructorLesson } from 'src/app/model/instructor-lesson';

@Injectable({
  providedIn: 'root'
})
export class InstructorLessonsService {

  private _url = serverPort;

  constructor(private _http: HttpClient) { }

  public getInstructorAdventures(instructorId: number): Observable<any>{
    return this._http.get<any>(this._url + 'instructorAdventure/getAdventures/' + instructorId);
  }

  public deleteLesson(lessonId: number): any {
    return this._http.delete(this._url + 'instructorAdventure/deleteAdventure/' + lessonId);
  }

  modifyLesson(modifedLesson: InstructorLesson): any {
    return this._http.post<InstructorLesson>(this._url + 'instructorAdventure/updateAdventure/', modifedLesson);
  }

  addLesson(newLesson: any) {
    return this._http.post<InstructorLesson>(this._url + 'instructorAdventure/createInstructorAdventure/', newLesson);
  }
}
