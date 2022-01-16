import { Component, OnInit } from '@angular/core';
import { MatDialog, throwMatDialogContentAlreadyAttachedError } from '@angular/material/dialog';
import { AdventureReservation } from 'src/app/model/adventure-reservation';
import { Report } from 'src/app/model/report';
import { User } from 'src/app/model/user';
import { ReservationsService } from 'src/app/services/reservations/reservations.service';
import { UserProfileService } from 'src/app/services/user-profile/user-profile.service';
import { InstructorAddAdventureReservationDialogComponent } from './instructor-add-adventure-reservation-dialog/instructor-add-adventure-reservation-dialog.component';
import { InstructorClientInfoDialogComponent } from './instructor-client-info-dialog/instructor-client-info-dialog.component';
import { InstructorReportDialogComponent } from './instructor-report-dialog/instructor-report-dialog.component';

@Component({
  selector: 'app-instructor-lesson-reservations-view',
  templateUrl: './instructor-lesson-reservations-view.component.html',
  styleUrls: ['./instructor-lesson-reservations-view.component.css']
})

export class InstructorLessonReservationsViewComponent implements OnInit {

  searchValue: string = "";
  reservations: AdventureReservation[] = [];


  constructor(private reservationService: ReservationsService,
              private detailsDialog: MatDialog,
              private userService: UserProfileService) { }

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

      this.reservationService.createAdventureReservationReport(report).subscribe();
    });
  }

  openReservationDialog(){
    const dialogRef = this.detailsDialog.open(InstructorAddAdventureReservationDialogComponent, {} );

    dialogRef.afterClosed().subscribe(reservation =>
      {
        this.reservationService.createAdventureReservation(reservation).subscribe(
          {
            next: succ => alert(succ),
            error: err => alert('The selected start time is busy!')
          })
      });
  }

  openClientInfoDialog(clientUsername: string){

    this.userService.getClient(clientUsername).subscribe(client => {
      const dialogRef = this.detailsDialog.open(InstructorClientInfoDialogComponent,
        {
          data: client
        } 
     );
    }
    )

  }

}
