import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-delete-account-dialog',
  templateUrl: './delete-account-dialog.component.html',
  styleUrls: ['./delete-account-dialog.component.css']
})
export class DeleteAccountDialogComponent{

  constructor(public dialogRef: MatDialogRef<DeleteAccountDialogComponent>,
              @Inject(MAT_DIALOG_DATA)
              public deleteReason: string) {}

}
