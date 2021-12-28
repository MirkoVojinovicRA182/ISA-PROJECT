import {Component, Inject} from '@angular/core';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import { InstructorLesson } from 'src/app/model/instructor-lesson';

@Component({
  selector: 'app-instructor-one-lesson-details',
  templateUrl: './instructor-one-lesson-details.component.html',
  styleUrls: ['./instructor-one-lesson-details.component.css']
})
export class InstructorOneLessonDetailsComponent{
  constructor(
    public dialogRef: MatDialogRef<InstructorOneLessonDetailsComponent>, @Inject(MAT_DIALOG_DATA) public data: any) {
    }
  
    onCloseClick(): void{
      this.dialogRef.close();
    }
}
