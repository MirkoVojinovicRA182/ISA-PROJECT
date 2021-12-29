import { Component, OnInit, Input, OnChanges, SimpleChanges } from '@angular/core';
import { Observable } from 'rxjs';
import { Instructor } from 'src/app/model/instructor';
import { InstructorLessonsService } from 'src/app/services/instructor-lessons/instructor-lessons.service';
import { InstructorLesson } from 'src/app/model/instructor-lesson';
import { MatDialog } from '@angular/material/dialog';
import { InstructorAddLessonComponent } from '../instructor-add-lesson/instructor-add-lesson.component';


@Component({
  selector: 'app-instructor-lessons',
  templateUrl: './instructor-lessons.component.html',
  styleUrls: ['./instructor-lessons.component.css']
})
export class InstructorLessonsComponent implements OnInit {

  @Input() loggedInstructor: Instructor = new Instructor();
  lessons: InstructorLesson[] = [];
  searchValue: string = ""
  foundedLessons: InstructorLesson[] = [];

  constructor(private _instructorLessonsService: InstructorLessonsService,
              public detailsDialog: MatDialog) { }


  ngOnInit(): void {
      this.getInstructorAdventures();
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

  showAddLessonDialog(): void{
    const dialogRef = this.detailsDialog.open(InstructorAddLessonComponent, {
      data: new InstructorLesson(),
      panelClass: 'backdropBackground',
      disableClose: true
    });

    dialogRef.afterClosed().subscribe(newLesson => {
      newLesson.instructorId = this.loggedInstructor.userId;
      this._instructorLessonsService.addLesson(newLesson).subscribe(() => this.getInstructorAdventures());
    });
  }

  findLesson(){
    this._instructorLessonsService.getInstructorAdventures(this.loggedInstructor.userId).subscribe(data =>
    {
      
      this.lessons = data
      this.foundedLessons = [];

      for(let lesson of this.lessons)
        if(lesson.name.toLocaleLowerCase().includes(this.searchValue.toLocaleLowerCase()))
          this.foundedLessons.push(lesson);

      this.lessons = this.foundedLessons;
      
    });
  }

}
