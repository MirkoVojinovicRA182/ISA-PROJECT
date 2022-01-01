import { Component, OnInit } from '@angular/core';
import { RegistrationRequest } from 'src/app/model/registration-request';
import { UserRegistrationService } from 'src/app/services/user-registration/user-registration.service';

@Component({
  templateUrl: './administrator-registration-requests.component.html',
  styleUrls: ['./administrator-registration-requests.component.css']
})
export class AdministratorRegistrationRequestsComponent implements OnInit {

  requests: RegistrationRequest[] = [];

  constructor(private userRegistrationService: UserRegistrationService) { }

  ngOnInit(): void {
    this.getRegistrationRequests();
  }

  getRegistrationRequests(): void{
    this.userRegistrationService.getRegistrationRequests().subscribe(requests => { this.requests = requests });
  }

  ejectRegistration(request: RegistrationRequest){
    this.userRegistrationService.ejectRegistration(request).subscribe(() => this.getRegistrationRequests());
  }

  approveRegistration(request: RegistrationRequest){
    this.userRegistrationService.approveRegistration(request).subscribe(() => this.getRegistrationRequests());
  }

}
