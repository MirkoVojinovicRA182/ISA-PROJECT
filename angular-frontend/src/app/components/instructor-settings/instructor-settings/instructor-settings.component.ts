import { Component, Input, OnInit } from '@angular/core';
import { Instructor } from 'src/app/model/instructor';
import { InstructorSettingsService } from 'src/app/services/instructor-settings/instructor-settings.service';

@Component({
  selector: 'app-instructor-settings',
  templateUrl: './instructor-settings.component.html',
  styleUrls: ['./instructor-settings.component.css']
})
export class InstructorSettingsComponent implements OnInit {

  changePasswordButtonClicked: boolean = false;
  deleteAccountButtonClicked: boolean = false;
  @Input() loggedInstructor: Instructor = new Instructor();
  oldPassword: string = "";
  newPassword: string = "";

  constructor(private _instructorSettingsService: InstructorSettingsService) { }

  ngOnInit(): void {
  }

  changePasword(): void{
    if(this.loggedInstructor.password == this.oldPassword)
    {
      alert('Uspešno ste izmenili šifru. Nova: ' + this.newPassword);
      this._instructorSettingsService.changePassword(
        {
          "userId": this.loggedInstructor.userId,
          "userType": "Instructor",
          "newPassword": this.newPassword
        }).subscribe();
    }
    else
      alert('Niste dobro uneli trenutnu šifru!');
  }

}
