import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { AdventureAdditionalService } from 'src/app/model/adventure-additional-service';

@Component({
  selector: 'app-instructor-additional-service-dialog',
  templateUrl: './instructor-additional-service-dialog.component.html',
  styleUrls: ['./instructor-additional-service-dialog.component.css']
})
export class InstructorAdditionalServiceDialogComponent{

  constructor(
    public dialogRef: MatDialogRef<InstructorAdditionalServiceDialogComponent>, @Inject(MAT_DIALOG_DATA) public additionalService: AdventureAdditionalService) {
    }
  
  closeDialog(): void{
    this.dialogRef.close();
  }
}
