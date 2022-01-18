import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Instructor } from 'src/app/model/instructor';
import { InstructorHomePageService } from 'src/app/services/instructor-home-page/instructor-home-page.service';

@Component({
  selector: 'app-instructor-home-page',
  templateUrl: './instructor-home-page.component.html',
  styleUrls: ['./instructor-home-page.component.css']
})
export class InstructorHomePageComponent implements OnInit {

  lessonsClicked: boolean = false;
  reservationsClicked: boolean = false;
  calendarClicked: boolean = false;
  reportClicked: boolean = false;
  profileClicked: boolean = false;
  settingsClicked: boolean = false;
  logoutClicked: boolean = false;

  instructor: Instructor = new Instructor();

  instructorId: number = 1;

  constructor(private _instructorHomePageService: InstructorHomePageService,
    public router: Router,
    public route: ActivatedRoute) { }

  ngOnInit(): void {
    this.getInstructor();
  }

  getInstructor():void {
    this._instructorHomePageService.getProfileInfo(this.instructorId).subscribe(data => {
      this.instructor = data;
    });
  }
}
