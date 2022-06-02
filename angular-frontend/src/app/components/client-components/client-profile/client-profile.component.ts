import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/model/user';
import { LoginService } from 'src/app/services/login/login.service';
import { UserProfileService } from 'src/app/services/user-profile/user-profile.service';

@Component({
  selector: 'app-client-profile',
  templateUrl: './client-profile.component.html',
  styleUrls: ['./client-profile.component.css']
})
export class ClientProfileComponent implements OnInit {

  inputsDisabled: boolean = true;

  loggedUser: User = new User();

  constructor(private userRegistrationService: UserProfileService, private loginService: LoginService) { }

  ngOnInit(): void {
    this.getLoggedUser();
  }

  getLoggedUser(){
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
  
  changeProfile(){
    this.userRegistrationService.changeProfileInfo(this.loggedUser).subscribe(() => this.inputsDisabled = true);
  }
}
