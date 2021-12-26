import { Component, OnInit } from '@angular/core';
import { Instructor } from '../../../model/instructor';
import { InstructorProfileInfoService } from '../../../services/instructor-profile-info.service';

@Component({
  selector: 'app-instructor-profile-info',
  templateUrl: './instructor-profile-info.component.html',
  styleUrls: ['./instructor-profile-info.component.css']
})
export class InstructorProfileInfoComponent implements OnInit {
  instructor: Instructor = new Instructor();
  inputDisabled: boolean = true;

  constructor(private _instructorProfileInfoService:InstructorProfileInfoService) { }

  ngOnInit(): void {
    this.getProfileInfo();
  }

  getProfileInfo():void {
    this._instructorProfileInfoService.getProfileInfo(1).subscribe(data => {
      this.instructor = data;
    });
  }

  changeProfileInfo(): void {
    this.instructor.userType = "Instructor";
    this._instructorProfileInfoService.changeProfileInfo(this.instructor).subscribe(() => {});
  }

  saveChanges(): void {
    this.inputDisabled = true;
    this.changeProfileInfo();
  }

}
