import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { UserSettingsService } from 'src/app/services/user-settings/user-settings.service';
import { ChangePasswordDialogComponent } from './change-password-dialog/change-password-dialog.component';
import { DeleteAccountDialogComponent } from './delete-account-dialog/delete-account-dialog.component';

@Component({
  selector: 'app-user-settings',
  templateUrl: './user-settings.component.html',
  styleUrls: ['./user-settings.component.css']
})
export class UserSettingsComponent implements OnInit {

  constructor(private detailsDialog: MatDialog,
              private userSettingsService: UserSettingsService) { }

  ngOnInit(): void {
  }

  openChangePasswordDialog(){
    const dialogRef = this.detailsDialog.open(ChangePasswordDialogComponent, {
    });

    dialogRef.afterClosed().subscribe(newPassword => {
      if(newPassword != undefined)
      {
        alert('Success. New password: ' + newPassword);
        this.userSettingsService.changePassword(
        {
          "userId": 2,
          "userType": "Administrator",
          "newPassword": newPassword
        }).subscribe();
      }
    });
  }

  openDeleteAccountDialog(){
    const dialogRef = this.detailsDialog.open(DeleteAccountDialogComponent, {
    });

    dialogRef.afterClosed().subscribe(deleteReason => {
      if(deleteReason != undefined)
      {
        this.userSettingsService.deleteAccount({
          "deleteReason": deleteReason,
          "userId": 2
        }).subscribe();
        alert('Your request for deleting account is now in proccess. Check your mail tomorow for more informations.')
      }
    });

  }

}
