import { Component, OnInit } from '@angular/core';
import { MatDialog, throwMatDialogContentAlreadyAttachedError } from '@angular/material/dialog';
import { Report } from 'src/app/model/report';
import { Reservation } from 'src/app/model/reservation';
import { ReservationsService } from 'src/app/services/reservations/reservations.service';
import { InstructorReportDialogComponent } from './instructor-report-dialog/instructor-report-dialog.component';

@Component({
  selector: 'app-instructor-lesson-reservations-view',
  templateUrl: './instructor-lesson-reservations-view.component.html',
  styleUrls: ['./instructor-lesson-reservations-view.component.css']
})

export class InstructorLessonReservationsViewComponent implements OnInit {

  searchValue: string = "";
  reservations: Reservation[] = [];


  constructor(private reservationService: ReservationsService,
              private detailsDialog: MatDialog) { }

  ngOnInit(): void {
    this.getReservations();
  }

  getReservations(){
    this.reservationService.getReservations(1).subscribe(reservations => this.reservations = reservations);
  }

  checkReservationEnd(endTime: Date): boolean{
    let currentDate = new Date();
    alert(endTime);
    return endTime.getDay < currentDate.getDay &&
           endTime.getFullYear < currentDate.getFullYear &&
           endTime.getMonth < currentDate.getMonth;
  }

  findReservation(){
   this.reservationService.getReservations(1).subscribe(data =>{
     this.reservations = data;
     let foundedReservations = [];

     for(let res of this.reservations)
        if(res.adventureName.toLocaleLowerCase().includes(this.searchValue.toLocaleLowerCase()))
          foundedReservations.push(res);

      this.reservations = foundedReservations;
   })
  }

  openReportDialog(reservationId: number){
    const dialogRef = this.detailsDialog.open(InstructorReportDialogComponent, {} );

    dialogRef.afterClosed().subscribe(reportText => {

      let report = new Report();
      report.reportText = reportText;
      report.reservationId = reservationId;

      this.reservationService.createAventureReservationReport(report).subscribe();
    });
  }

}
