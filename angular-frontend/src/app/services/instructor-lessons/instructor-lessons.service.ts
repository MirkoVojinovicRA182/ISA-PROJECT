import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { serverPort } from 'src/app/app.consts';
import { AdventureAdditionalService } from 'src/app/model/adventure-additional-service';
import { Image } from 'src/app/model/image';
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

  getAdditionalServices(adventureId: number): Observable<any[]> {
    return this._http.get<any[]>(this._url + 'instructorAdventure/getAdditionalServices/' + adventureId);
  }

  getImages(adventureId: number): Observable<Image[]> {
    return this._http.get<Image[]>(this._url + 'instructorAdventure/getImages/' + adventureId);
  }

  deleteLesson(lessonId: number): any {
    return this._http.delete(this._url + 'instructorAdventure/deleteAdventure/' + lessonId);
  }

  deleteAdditionalService(additionalServiceId: number) {
    return this._http.delete(this._url + 'instructorAdventure/deleteAdditionalService/' + additionalServiceId);
  }

  deleteImage(imageId: number) {
    return this._http.delete(this._url + 'instructorAdventure/deleteImage/' + imageId);
  }


  modifyLesson(modifedLesson: InstructorLesson): any {
    return this._http.post<InstructorLesson>(this._url + 'instructorAdventure/updateAdventure/', modifedLesson);
  }

  addLesson(newLesson: any) {
    return this._http.post<InstructorLesson>(this._url + 'instructorAdventure/createInstructorAdventure/', newLesson);
  }

  addImage(image: Image): Observable<Image>{
    return this._http.post<Image>(this._url + 'instructorAdventure/addImage', image);
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
