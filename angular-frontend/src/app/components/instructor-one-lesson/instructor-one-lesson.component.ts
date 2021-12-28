import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';

@Component({
  selector: 'app-instructor-one-lesson',
  templateUrl: './instructor-one-lesson.component.html',
  styleUrls: ['./instructor-one-lesson.component.css']
})
export class InstructorOneLessonComponent implements OnInit {

  @Input() lesson: any
  @Output() deleteButtonClicked: EventEmitter<string> = new EventEmitter<string>();

  constructor(public detailsDialog: MatDialog) { }

  ngOnInit(): void {
  }

  onDeleteButtonClick(){
    this.deleteButtonClicked.emit(this.lesson.id);
  }

  seeDetailsDialog(){

  }

}
