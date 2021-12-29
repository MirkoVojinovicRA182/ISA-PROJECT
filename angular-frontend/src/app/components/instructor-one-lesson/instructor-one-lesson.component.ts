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
    let tempLesson = this.createTempLesson(); 
    const dialogRef = this.detailsDialog.open(InstructorOneLessonDetailsComponent, {
      data: tempLesson,
      panelClass: 'backdropBackground',
      disableClose: true
    });

    dialogRef.afterClosed().subscribe(modifedLesson => {
      if(modifedLesson != undefined && this.lessonIsModifed(tempLesson))
        this.lessonModifed.emit(modifedLesson);
    });
  }

  lessonIsModifed(tempLesson: InstructorLesson): boolean{
    return  tempLesson.id != this.lesson.id ||
            tempLesson.name != this.lesson.name ||
            tempLesson.address != this.lesson.address ||
            tempLesson.promotionalDescription != this.lesson.promotionalDescription ||
            tempLesson.instructorBiography != this.lesson.instructorBiography ||
            tempLesson.maxCountOfParticipants != this.lesson.maxCountOfParticipants ||
            tempLesson.rulesOfConduct != this.lesson.rulesOfConduct ||
            tempLesson.defaultEquipment != this.lesson.defaultEquipment ||
            tempLesson.pricelist != this.lesson.pricelist ||
            tempLesson.termsOfUse != this.lesson.termsOfUse;
  }

  createTempLesson(): InstructorLesson{
    let tempLesson = new InstructorLesson();

    tempLesson.id = this.lesson.id;
    tempLesson.name = this.lesson.name;
    tempLesson.address = this.lesson.address;
    tempLesson.promotionalDescription = this.lesson.promotionalDescription;
    tempLesson.instructorBiography = this.lesson.instructorBiography;
    tempLesson.maxCountOfParticipants = this.lesson.maxCountOfParticipants;
    tempLesson.rulesOfConduct = this.lesson.rulesOfConduct;
    tempLesson.defaultEquipment = this.lesson.defaultEquipment;
    tempLesson.pricelist = this.lesson.pricelist;
    tempLesson.termsOfUse = this.lesson.termsOfUse;

    return tempLesson;
  }



}
