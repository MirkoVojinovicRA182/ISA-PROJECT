import { formatDate } from '@angular/common';
import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { ReservationsService } from 'src/app/services/reservations/reservations.service';

@Component({
  selector: 'app-instructor-statistics',
  templateUrl: './instructor-statistics.component.html',
  styleUrls: ['./instructor-statistics.component.css']
})
export class InstructorStatisticsComponent implements OnInit {

  buttonClass: string = "myButton";
  role: string = "Instructor";

  graphicsChecked: boolean = false;
  sallaryChecked: boolean = false;


  constructor() { }

  ngOnInit(): void {
  }

  showGraphics(){
    this.sallaryChecked = false;
    this.graphicsChecked = true;
  }

  showSallary(){
    this.sallaryChecked = true;
    this.graphicsChecked = false;
  }
}
