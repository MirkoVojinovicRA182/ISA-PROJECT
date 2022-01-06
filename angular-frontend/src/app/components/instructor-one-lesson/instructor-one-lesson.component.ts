import { ChangeDetectionStrategy } from '@angular/compiler';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import { InstructorLesson } from 'src/app/model/instructor-lesson';

@Component({
  selector: 'app-instructor-one-lesson',
  templateUrl: './instructor-one-lesson.component.html',
  styleUrls: ['./instructor-one-lesson.component.css']
})
export class InstructorOneLessonComponent implements OnInit {

  @Input() lesson!: InstructorLesson
  @Output() deleteButtonClicked: EventEmitter<number> = new EventEmitter<number>();

  isDisabled: boolean = true;

  constructor(public detailsDialog: MatDialog) { }

  ngOnInit(): void {
  }

  onDeleteButtonClick(){
    this.deleteButtonClicked.emit(this.lesson.id);
  }
}
