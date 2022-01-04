import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/model/user';
import { UserProfileService } from 'src/app/services/user-profile/user-profile.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  inputsDisabled: boolean = true;

  loggedUser: User = new User();

  constructor(private userRegistrationService: UserProfileService) { }

  ngOnInit(): void {
    this.getLoggedUser();
  }

  getLoggedUser(){
    this.userRegistrationService.getAdminProfileInfo(2).subscribe(loggedUser => this.loggedUser = loggedUser);
  }
  
  changeProfile(){
    this.loggedUser.userType = 'Administrator';
    this.userRegistrationService.changeProfileInfo(this.loggedUser).subscribe(() => this.inputsDisabled = true);
  }

}
