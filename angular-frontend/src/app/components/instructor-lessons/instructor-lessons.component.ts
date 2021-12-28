import { Component, OnInit, Input, OnChanges, SimpleChanges } from '@angular/core';
import { Instructor } from 'src/app/model/instructor';
import { InstructorLessonsService } from 'src/app/services/instructor-lessons/instructor-lessons.service';

@Component({
  selector: 'app-instructor-lessons',
  templateUrl: './instructor-lessons.component.html',
  styleUrls: ['./instructor-lessons.component.css']
})
export class InstructorLessonsComponent implements OnInit, OnChanges {

  @Input() loggedInstructor: Instructor = new Instructor();
  lessons: any

  constructor(private _instructorLessonsService: InstructorLessonsService) { }

  ngOnChanges(changes: SimpleChanges): void {
    this.getInstructorAdventures();
  }

  ngOnInit(): void {
    //this.getInstructorAdventures();
  }

  getInstructorAdventures(): void{
    this._instructorLessonsService.getInstructorAdventures(this.loggedInstructor.userId)
    .subscribe(data => { this.lessons = data});
    ;
  }

  onDeleteButtonClicked(lessonId: string): void{
    this._instructorLessonsService.deleteLesson(lessonId).subscribe(() => this.getInstructorAdventures());
  }

}
