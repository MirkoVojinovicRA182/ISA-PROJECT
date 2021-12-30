import { Component, OnInit } from '@angular/core';
import { Administrator } from 'src/app/model/administrator';
import { UserRegistrationService } from 'src/app/services/user-registration/user-registration.service';

@Component({
  selector: 'app-administrator-register-administrator',
  templateUrl: './administrator-register-administrator.component.html',
  styleUrls: ['./administrator-register-administrator.component.css']
})
export class AdministratorRegisterAdministratorComponent implements OnInit {

  newAdmin: Administrator = new Administrator();

  constructor(private userRegistrationService: UserRegistrationService) { }

  ngOnInit(): void {
  }

  registerAdmin(){
    this.userRegistrationService.registerAdmin(this.newAdmin).subscribe(() =>
    {
       alert('Admin uspešno registrovan!');
    });
  }

}
