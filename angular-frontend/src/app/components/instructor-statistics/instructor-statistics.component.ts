import { formatDate } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ReservationsService } from 'src/app/services/reservations/reservations.service';

@Component({
  selector: 'app-instructor-statistics',
  templateUrl: './instructor-statistics.component.html',
  styleUrls: ['./instructor-statistics.component.css']
})
export class InstructorStatisticsComponent implements OnInit {

  graphicsChecked: boolean = false;
  sallaryChecked: boolean = false;

  messageDisplayed: boolean = false;
  todayDate:string = formatDate(new Date(), 'yyyy-MM-ddThh:mm:ss.SSS', 'en_US');


  fromDate: Date = new Date();
  toDate: Date = new Date();

  generatedSallary: number = -1;

  constructor(private reservationService: ReservationsService) { }

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

  generateSallary(){

    this.reservationService.getInstructorSallary(this.fromDate, this.toDate, 1).subscribe(sallary => 
      {
        this.generatedSallary = sallary;
        this.messageDisplayed = true;
      }
    );
  }

}
