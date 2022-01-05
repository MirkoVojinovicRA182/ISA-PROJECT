import { Component, OnInit } from '@angular/core';
import { DeleteAccountRequest } from 'src/app/model/delete-account-request';
import { AdministratorDeleteAccountRequestsService } from 'src/app/services/administrator-delete-account-requests/administrator-delete-account-requests.service';

@Component({
  selector: 'app-administrator-delete-account-requests-view',
  templateUrl: './administrator-delete-account-requests-view.component.html',
  styleUrls: ['./administrator-delete-account-requests-view.component.css']
})
export class AdministratorDeleteAccountRequestsViewComponent implements OnInit {

  searchValue: string = "";
  requests: DeleteAccountRequest[] = [];

  constructor(private service: AdministratorDeleteAccountRequestsService) { }

  ngOnInit(): void {
    this.getRequests();
  }

  getRequests(){
    this.service.getRequests().subscribe(requests => this.requests = requests);
  }

  deleteAccount(deleteAccountRequest: DeleteAccountRequest){
    this.service.deleteAccount(deleteAccountRequest).subscribe(() => this.getRequests());
  }

  ejectRequest(requestId: number){
    this.service.ejectRequest(requestId).subscribe(() => this.getRequests());
  }
  findRequest(){

  }

}
