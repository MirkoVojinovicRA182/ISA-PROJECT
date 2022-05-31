import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { UserSettingsService } from 'src/app/services/user-settings/user-settings.service';

@Component({
  selector: 'app-cottage-owner-delete-account',
  templateUrl: './cottage-owner-delete-account.component.html',
  styleUrls: ['./cottage-owner-delete-account.component.css']
})
export class CottageOwnerDeleteAccountComponent{

  constructor(public dialogRef: MatDialogRef<CottageOwnerDeleteAccountComponent>, @Inject(MAT_DIALOG_DATA) public data: any, public service: UserSettingsService) { }

  send(): void {
    this.service.createDeleteAccountRequest(this.data).subscribe()
  }

}
