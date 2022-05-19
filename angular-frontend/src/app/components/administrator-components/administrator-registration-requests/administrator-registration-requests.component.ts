import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { EjectRegistrationRequest } from 'src/app/model/eject-registration-request';
import { RegistrationRequest } from 'src/app/model/registration-request';
import { UserRegistrationService } from 'src/app/services/user-registration/user-registration.service';
import { EjectRegistrationRequestComponent } from './eject-registration-request/eject-registration-request.component';

@Component({
  templateUrl: './administrator-registration-requests.component.html',
  styleUrls: ['./administrator-registration-requests.component.css']
})
export class AdministratorRegistrationRequestsComponent implements OnInit {

  requests: RegistrationRequest[] = [];
  searchValue: string = "";

  constructor(private userRegistrationService: UserRegistrationService,
              private detailsDialog: MatDialog) { }

  ngOnInit(): void {
    this.getRegistrationRequests();
  }

  getRegistrationRequests(): void{
    this.userRegistrationService.getRegistrationRequests().subscribe(requests => { this.requests = requests });
  }

  ejectRegistration(request: RegistrationRequest){

    const dialogRef = this.detailsDialog.open(EjectRegistrationRequestComponent, {});

    dialogRef.afterClosed().subscribe(retVal => 
      {
        if(retVal.closed != true){
          let ejectRegistrationRequest = new EjectRegistrationRequest();

          ejectRegistrationRequest.requestId = request.id;
          ejectRegistrationRequest.clientEmail = request.email;
          ejectRegistrationRequest.ejectExplanation = retVal.ejectExplanation;

          this.userRegistrationService.ejectRegistration(ejectRegistrationRequest).subscribe(() => this.getRegistrationRequests())
        }
      });
  }

  approveRegistration(request: RegistrationRequest){
    this.userRegistrationService.approveRegistration(request).subscribe(() => this.getRegistrationRequests());
  }

  findRequest(){
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
