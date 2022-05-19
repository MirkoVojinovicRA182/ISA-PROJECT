import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-eject-registration-request',
  templateUrl: './eject-registration-request.component.html',
  styleUrls: ['./eject-registration-request.component.css']
})
export class EjectRegistrationRequestComponent implements OnInit {

  retVal = {
    ejectExplanation: "",
    closed: false
  }

  constructor(public dialogRef: MatDialogRef<EjectRegistrationRequestComponent>) { }

  ngOnInit(): void {
  }

  closeDialog(){
    this.retVal.closed = true;
    this.dialogRef.close();
  }

}
