import { ChangeDetectionStrategy } from '@angular/compiler';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import { InstructorLesson } from 'src/app/model/instructor-lesson';
import { InstructorOneLessonDetailsComponent } from '../instructor-one-lesson-details/instructor-one-lesson-details.component';

@Component({
  selector: 'app-instructor-one-lesson',
  templateUrl: './instructor-one-lesson.component.html',
  styleUrls: ['./instructor-one-lesson.component.css']
})
export class InstructorOneLessonComponent implements OnInit {

  @Input() lesson!: InstructorLesson
  tempLesson!: InstructorLesson
  @Output() deleteButtonClicked: EventEmitter<number> = new EventEmitter<number>();
  @Output() lessonModifed: EventEmitter<any> = new EventEmitter<string>();

  isDisabled: boolean = true;

  constructor(public detailsDialog: MatDialog) { }

  ngOnInit(): void {
  }

  onDeleteButtonClick(){
    this.deleteButtonClicked.emit(this.lesson.id);
  }

  seeDetailsDialog(){
    this.tempLesson = new InstructorLesson(this.lesson);
    const dialogRef = this.detailsDialog.open(InstructorOneLessonDetailsComponent, {
      data: this.tempLesson,
      panelClass: 'backdropBackground',
      disableClose: true
    });

    dialogRef.afterClosed().subscribe(modifedLesson => {
      if(modifedLesson != undefined && this.lessonIsModifed())
        this.lessonModifed.emit(modifedLesson);
    });
  }

  lessonIsModifed(): boolean{
    return  this.tempLesson.id != this.lesson.id ||
            this.tempLesson.name != this.lesson.name ||
            this.tempLesson.address != this.lesson.address ||
            this.tempLesson.promotionalDescription != this.lesson.promotionalDescription ||
            this.tempLesson.instructorBiography != this.lesson.instructorBiography ||
            this.tempLesson.maxCountOfParticipants != this.lesson.maxCountOfParticipants ||
            this.tempLesson.rulesOfConduct != this.lesson.rulesOfConduct ||
            this.tempLesson.defaultEquipment != this.lesson.defaultEquipment ||
            this.tempLesson.pricelist != this.lesson.pricelist ||
            this.tempLesson.termsOfUse != this.lesson.termsOfUse;
  }



}
