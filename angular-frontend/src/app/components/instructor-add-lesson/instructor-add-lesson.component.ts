import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-instructor-add-lesson',
  templateUrl: './instructor-add-lesson.component.html',
  styleUrls: ['./instructor-add-lesson.component.css']
})
export class InstructorAddLessonComponent{

  constructor(
    public dialogRef: MatDialogRef<InstructorAddLessonComponent>, @Inject(MAT_DIALOG_DATA) public data: any) {
    }


  onCloseClick(): void{
    this.dialogRef.close();
  }

}
