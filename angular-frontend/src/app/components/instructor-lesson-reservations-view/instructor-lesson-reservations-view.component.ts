import { Component, OnInit } from '@angular/core';
import { throwMatDialogContentAlreadyAttachedError } from '@angular/material/dialog';
import { ReservationsService } from 'src/app/services/reservations/reservations.service';

@Component({
  selector: 'app-instructor-lesson-reservations-view',
  templateUrl: './instructor-lesson-reservations-view.component.html',
  styleUrls: ['./instructor-lesson-reservations-view.component.css']
})

export class InstructorLessonReservationsViewComponent implements OnInit {

  searchValue: string = "";
  reservations: any;


  constructor(private reservationService: ReservationsService) { }

  ngOnInit(): void {
    this.getReservations();
  }

  getReservations(){
    this.reservationService.getReservations(1).subscribe(reservations => this.reservations = reservations);
  }

  checkReservationEnd(endTime: Date): boolean{
    return endTime < new Date();
  }

  findReservation(){
    
  }

}
