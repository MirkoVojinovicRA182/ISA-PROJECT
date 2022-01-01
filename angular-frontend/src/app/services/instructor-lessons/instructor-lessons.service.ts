import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { serverPort } from 'src/app/app.consts';
import { Instructor } from 'src/app/model/instructor';
import { InstructorLesson } from 'src/app/model/instructor-lesson';

@Injectable({
  providedIn: 'root'
})
export class InstructorLessonsService {

  private _url = serverPort;

  constructor(private _http: HttpClient) { }

  getInstructorAdventures(instructorId: number): Observable<any>{
    return this._http.get<any>(this._url + 'instructorAdventure/getAdventures/' + instructorId);
  }

  deleteLesson(lessonId: number): any {
    return this._http.delete(this._url + 'instructorAdventure/deleteAdventure/' + lessonId);
  }

  modifyLesson(modifedLesson: InstructorLesson): any {
    return this._http.post<InstructorLesson>(this._url + 'instructorAdventure/updateAdventure/', modifedLesson);
  }

  addLesson(newLesson: any) {
    return this._http.post<InstructorLesson>(this._url + 'instructorAdventure/createInstructorAdventure/', newLesson);
  }

  getAllLessons(): Observable<InstructorLesson[]> {
    return this._http.get<InstructorLesson[]>(this._url + 'entity/getAllAdventures/');
  }
}
