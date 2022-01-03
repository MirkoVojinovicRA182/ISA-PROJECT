import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { serverPort } from 'src/app/app.consts';
import { AdventureAdditionalService } from 'src/app/model/adventure-additional-service';
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

  getAdditionalServices(adventureId: number) {
    return this._http.get<AdventureAdditionalService[]>(this._url + 'instructorAdventure/getAdditionalServices/' + adventureId);
  }

  deleteLesson(lessonId: number): any {
    return this._http.delete(this._url + 'instructorAdventure/deleteAdventure/' + lessonId);
  }

  deleteAdditionalService(additionalServiceId: number) {
    return this._http.delete(this._url + 'instructorAdventure/deleteAdditionalService/' + additionalServiceId);
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

  getLessonById(lessonId: number): Observable<InstructorLesson>{
    return this._http.get<InstructorLesson>(this._url + 'instructorAdventure/getAdventureById/' + lessonId);
  }

  addAdditionalService(newAdditionalService: AdventureAdditionalService) {
    return this._http.post<AdventureAdditionalService>(this._url + 'instructorAdventure/createAdditionalService/', newAdditionalService);
  }
}
