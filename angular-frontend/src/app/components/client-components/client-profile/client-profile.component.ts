import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { User } from 'src/app/model/user';
import { LoginService } from 'src/app/services/login/login.service';
import { UserProfileService } from 'src/app/services/user-profile/user-profile.service';
import { UserSettingsService } from 'src/app/services/user-settings/user-settings.service';
import { DeleteAccountDialogComponent } from '../../unregistered-user-components/user-settings/delete-account-dialog/delete-account-dialog.component';

@Component({
  selector: 'app-client-profile',
  templateUrl: './client-profile.component.html',
  styleUrls: ['./client-profile.component.css']
})
export class ClientProfileComponent implements OnInit {

  inputsDisabled: boolean = true;

  loggedUser: User = new User();

  constructor(private userRegistrationService: UserProfileService,
    private loginService: LoginService,
    private detailsDialog: MatDialog,
    private userSettingsService: UserSettingsService) { }

  ngOnInit(): void {
    this.getLoggedUser();
  }

  getLoggedUser() {
    let user = this.loginService.whoami();
    this.loggedUser = {
      userId: user.id,
      name: user.name,
      lastName: user.lastName,
      email: user.email,
      address: user.address,
      city: user.city,
      country: user.country,
      phoneNumber: user.phoneNumber,
      userType: user.roles[0].name
    }
  }

  changeProfile() {
    this.userRegistrationService.changeProfileInfo(this.loggedUser).subscribe(() => this.inputsDisabled = true);
  }

  openDeleteAccountDialog() {
    const dialogRef = this.detailsDialog.open(DeleteAccountDialogComponent, {
    });
    let fullname = this.loggedUser.name + ' ' + this.loggedUser.lastName;
    dialogRef.afterClosed().subscribe(deleteReason => {
      if (deleteReason != undefined) {
        this.userSettingsService.createDeleteAccountRequest({
          "deleteReason": deleteReason,
          "userId": this.loggedUser.userId,
          "userFullName": fullname,
          "userType": "Client"

        }).subscribe();
        alert('Your request for deleting account is now in proccess. Check your mail tomorow for more informations.')
      }
    });
  }
}
