import { Component, OnInit, Input, OnChanges, SimpleChanges } from '@angular/core';
import { Observable } from 'rxjs';
import { Instructor } from 'src/app/model/instructor';
import { InstructorLessonsService } from 'src/app/services/instructor-lessons/instructor-lessons.service';
import { InstructorLesson } from 'src/app/model/instructor-lesson';


@Component({
  selector: 'app-instructor-lessons',
  templateUrl: './instructor-lessons.component.html',
  styleUrls: ['./instructor-lessons.component.css']
})
export class InstructorLessonsComponent implements OnInit, OnChanges {

  @Input() loggedInstructor: Instructor = new Instructor();
  lessons: InstructorLesson[] = [];

  constructor(private _instructorLessonsService: InstructorLessonsService) { }

  ngOnChanges(changes: SimpleChanges): void {
    this.getInstructorAdventures();
  }

  ngOnInit(): void {
  }

  getInstructorAdventures(): void{
    this._instructorLessonsService.getInstructorAdventures(this.loggedInstructor.userId)
    .subscribe(data => { this.lessons = data});
    ;
  }

  onDeleteButtonClicked(lessonId: number): void{
    this._instructorLessonsService.deleteLesson(lessonId).subscribe(() => this.getInstructorAdventures());
  }

  onLessonModifed(modifedLesson: InstructorLesson): void{
    this._instructorLessonsService.modifyLesson(modifedLesson).subscribe(() => this.getInstructorAdventures());
  }

}
