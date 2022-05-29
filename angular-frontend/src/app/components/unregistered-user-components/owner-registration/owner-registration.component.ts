import { Component, OnInit } from '@angular/core';
import { RegistrationRequest } from 'src/app/model/registration-request';
import { UserRegistrationService } from 'src/app/services/user-registration/user-registration.service';

@Component({
  selector: 'app-owner-registration',
  templateUrl: './owner-registration.component.html',
  styleUrls: ['./owner-registration.component.css']
})
export class OwnerRegistrationComponent implements OnInit {

  registrationRequest: RegistrationRequest = new RegistrationRequest();

  repeatedPassword: string = "";
  
  constructor(private registrationService: UserRegistrationService) { }

  ngOnInit(): void {
    this.registrationRequest.userType = "Client"
  }

  registerUser(){
    if(this.repeatedPassword == this.registrationRequest.password){
      if(this.registrationRequest.userType != "Client"){
        this.registrationService.sendRegistrationRequest(this.registrationRequest).subscribe(
          () => {
            alert("Registration request is sent to administrator. Check your mail latter for more informations.");
          }
        );
      }
      else {
        this.registrationService.registerClient(this.registrationRequest).subscribe(
          () => {
            alert("Registration request is sent to mail. Check your mail latter for account verification.");
          }
        )
      }
      return;
    }
    alert('Repeated password is not same!!!');
    
  }

}
