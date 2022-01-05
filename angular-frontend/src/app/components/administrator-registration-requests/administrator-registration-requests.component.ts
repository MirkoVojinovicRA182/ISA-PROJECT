import { Component, OnInit } from '@angular/core';
import { RegistrationRequest } from 'src/app/model/registration-request';
import { UserRegistrationService } from 'src/app/services/user-registration/user-registration.service';

@Component({
  templateUrl: './administrator-registration-requests.component.html',
  styleUrls: ['./administrator-registration-requests.component.css']
})
export class AdministratorRegistrationRequestsComponent implements OnInit {

  requests: RegistrationRequest[] = [];
  searchValue: string = "";

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

  findRequest(){
    /*
    this.instructorLessonService.getAdditionalServices(this.lesson.id).subscribe(
      services =>
      {
         this.additionalServices = services
         this.foundedAdditionalServices = [];

         for(let service of this.additionalServices)
          if(service.name.toLocaleLowerCase().includes(this.searchValue.toLocaleLowerCase()))
            this.foundedAdditionalServices.push(service);

         this.additionalServices = this.foundedAdditionalServices;
      }
    );
    */

    this.userRegistrationService.getRegistrationRequests().subscribe(
      requests =>
      {
        this.requests = requests;
        let foundedRequests = [];

        for(let req of this.requests){
          let requestFullName = req.name + ' ' + req.lastName;
          if(requestFullName.toLocaleLowerCase().includes(this.searchValue.toLocaleLowerCase()))
            foundedRequests.push(req);
        }
        
        this.requests = foundedRequests;
      }
    );
  }

}
