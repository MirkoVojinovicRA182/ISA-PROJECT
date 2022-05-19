import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ComplaintAnswer } from 'src/app/model/complaint-answer';
import { InstructorComplaint } from 'src/app/model/instructor-complaint';

@Component({
  selector: 'app-write-answer-dialog',
  templateUrl: './write-answer-dialog.component.html',
  styleUrls: ['./write-answer-dialog.component.css']
})
export class WriteAnswerDialogComponent implements OnInit {

  answerText: string = "";

  constructor(public dialogRef: MatDialogRef<WriteAnswerDialogComponent>) {}

  ngOnInit(): void {
  }


}
