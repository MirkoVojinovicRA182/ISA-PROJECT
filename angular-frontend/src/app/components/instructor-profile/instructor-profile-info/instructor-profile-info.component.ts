import { Component, Input, OnInit } from '@angular/core';
import { Instructor } from '../../../model/instructor';
import { InstructorProfileInfoService } from '../../../services/instructor-profile/instructor-profile-info.service';

@Component({
  selector: 'app-instructor-profile-info',
  templateUrl: './instructor-profile-info.component.html',
  styleUrls: ['./instructor-profile-info.component.css']
})
export class InstructorProfileInfoComponent implements OnInit {
  @Input() loggedInstructor: Instructor = new Instructor();
  inputDisabled: boolean = true;

  constructor(private _instructorProfileInfoService:InstructorProfileInfoService) { }

  ngOnInit(): void {
  }

  changeProfileInfo(): void {
    this.loggedInstructor.userType = "Instructor";
    this._instructorProfileInfoService.changeProfileInfo(this.loggedInstructor).subscribe(() => {});
  }

  saveChanges(): void {
    this.inputDisabled = true;
    this.changeProfileInfo();
  }

}
