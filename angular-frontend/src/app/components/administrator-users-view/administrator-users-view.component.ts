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

}
