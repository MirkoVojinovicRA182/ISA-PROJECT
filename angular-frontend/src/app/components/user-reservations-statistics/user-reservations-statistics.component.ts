import { formatDate } from '@angular/common';
import { Component, Input, OnInit } from '@angular/core';
import { ReservationsService } from 'src/app/services/reservations/reservations.service';

@Component({
  selector: 'app-user-reservations-statistics',
  templateUrl: './user-reservations-statistics.component.html',
  styleUrls: ['./user-reservations-statistics.component.css']
})
export class UserReservationsStatisticsComponent implements OnInit {

  fromDate: Date = new Date();
  toDate: Date = new Date();

  @Input() generateButtonClass = "";

  todayDate:string = formatDate(new Date(), 'yyyy-MM-dd', 'en_US');

  generateClicked: boolean = false;

  reservations: any;

  reservationsCount: number = 0;

  constructor(private reservationService: ReservationsService) { }

  ngOnInit(): void {
  }

  getReservations(){
    this.reservationService.getReservationStatistics(
      {
        "fromDate": this.fromDate,
        "toDate": this.toDate,
        "userId": 1
      }
    ).subscribe(reservations => {
      
      this.reservationsCount = 0;

      this.reservations = reservations;

      for(let res of this.reservations)
        this.reservationsCount += 1;

      this.generateClicked = true;

    })
  }

}
