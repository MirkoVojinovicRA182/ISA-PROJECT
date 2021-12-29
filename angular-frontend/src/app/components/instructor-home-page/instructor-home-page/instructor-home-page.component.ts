import { Component, Input, OnInit } from '@angular/core';
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

  constructor(private _instructorHomePageService: InstructorHomePageService) { }

  ngOnInit(): void {
    this.getInstructor();
  }

  getInstructor():void {
    this._instructorHomePageService.getProfileInfo(1).subscribe(data => {
      this.instructor = data;
    });
  }

  showLessons(): void{
    this.lessonsClicked = true;
    this.reservationsClicked = false;
    this.calendarClicked = false;
    this.reportClicked = false;
    this.profileClicked = false;
    this.settingsClicked = false;
    this.logoutClicked = false;
  }

  showReservations(): void{
    this.lessonsClicked = false;
    this.reservationsClicked = true;
    this.calendarClicked = false;
    this.reportClicked = false;
    this.profileClicked = false;
    this.settingsClicked = false;
    this.logoutClicked = false;
  }

  showCalendar(): void{
    this.lessonsClicked = false;
    this.reservationsClicked = false;
    this.calendarClicked = true;
    this.reportClicked = false;
    this.profileClicked = false;
    this.settingsClicked = false;
    this.logoutClicked = false;
  }

  showReports(): void{
    this.lessonsClicked = false;
    this.reservationsClicked = false;
    this.calendarClicked = false;
    this.reportClicked = true;
    this.profileClicked = false;
    this.settingsClicked = false;
    this.logoutClicked = false;
  }

  showProfile(): void{
    this.lessonsClicked = false;
    this.reservationsClicked = false;
    this.calendarClicked = false;
    this.reportClicked = false;
    this.profileClicked = true;
    this.settingsClicked = false;
    this.logoutClicked = false;
  }

  showSettings(): void{
    this.lessonsClicked = false;
    this.reservationsClicked = false;
    this.calendarClicked = false;
    this.reportClicked = false;
    this.profileClicked = false;
    this.settingsClicked = true;
    this.logoutClicked = false;
  }

  showLogout(): void{
    this.lessonsClicked = false;
    this.reservationsClicked = false;
    this.calendarClicked = false;
    this.reportClicked = false;
    this.profileClicked = false;
    this.settingsClicked = false;
    this.logoutClicked = true;
  }

}
