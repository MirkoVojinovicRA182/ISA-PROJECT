import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-instructor-report-dialog',
  templateUrl: './instructor-report-dialog.component.html',
  styleUrls: ['./instructor-report-dialog.component.css']
})
export class InstructorReportDialogComponent{

  noSelected: boolean = true;

  constructor(public dialogRef: MatDialogRef<InstructorReportDialogComponent>,
              @Inject(MAT_DIALOG_DATA)
              public reportText: string) {}

  
  setNoSelected(e: boolean){
    this.noSelected = e;

    if(e)
      this.reportText = "Client did not come.";
    else
    this.reportText = "";

  }

}
