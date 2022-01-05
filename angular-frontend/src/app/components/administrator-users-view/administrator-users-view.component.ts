import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/model/user';
import { UserRegistrationService } from 'src/app/services/user-registration/user-registration.service';

@Component({
  selector: 'app-administrator-users-view',
  templateUrl: './administrator-users-view.component.html',
  styleUrls: ['./administrator-users-view.component.css']
})
export class AdministratorUsersViewComponent implements OnInit {

  users: User[] =  [];
  searchValue: string = "";

  constructor(private userRegistrationService: UserRegistrationService) { }

  ngOnInit(): void {
    this.getUsers();
  }

  getUsers(){
    this.userRegistrationService.getUsers().subscribe(data => this.users = data);
  }

  deleteUser(user: User){
    this.userRegistrationService.deleteUser(user).subscribe(() => this.getUsers());
  }

  findUser(){

    /*
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
    */

    this.userRegistrationService.getUsers().subscribe(
      users =>
      {
        this.users = users;
        let foundedUsers = [];

        for(let user of this.users){
          let userFullName = user.name + ' ' + user.lastName;
          if(userFullName.toLocaleLowerCase().includes(this.searchValue.toLocaleLowerCase()))
          foundedUsers.push(user);
        }

        this.users = foundedUsers;
      }
    );

  }

}
