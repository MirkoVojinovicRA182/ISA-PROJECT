import { Component, OnInit } from '@angular/core';
import { DialogService, DynamicDialogConfig, DynamicDialogRef } from 'primeng/dynamicdialog';
import { InstructorHomePageService } from 'src/app/services/instructor-home-page/instructor-home-page.service';
import { ReservationsService } from 'src/app/services/reservations/reservations.service';

@Component({
  selector: 'app-client-history',
  templateUrl: './client-history.component.html',
  styleUrls: ['./client-history.component.css'],
  providers: [DialogService]
})
export class ClientHistoryComponent implements OnInit {

  cottageRes: any;
  cottageCurr: any;

  adventureRes: any;
  adventureCurr: any;

  shipRes: any;
  shipCurr: any;

  currentUser: any;

  constructor(private resService: ReservationsService,
    public dialogService: DialogService) { }

  ngOnInit(): void {
    let user = localStorage.getItem('currentUser')
    if (user != null) {
      this.currentUser = JSON.parse(user)
    }
    this.resService.getCottageHistoryReservationByClientId(this.currentUser.id).subscribe(data => {
      this.cottageRes = data
    })
    this.resService.getCottageCurrentReservationByClientId(this.currentUser.id).subscribe(data => {
      this.cottageCurr = data
    })
    this.resService.getShipHistoryReservationByClientId(this.currentUser.id).subscribe(data => {
      this.shipRes = data
    })
    this.resService.getShipCurrentReservationByClientId(this.currentUser.id).subscribe(data => {
      this.shipCurr = data
    })
    this.resService.getAdventureHistoryReservationByClientId(this.currentUser.id).subscribe(data => {
      this.adventureRes = data
    })
    this.resService.getAdventureCurrentReservationByClientId(this.currentUser.id).subscribe(data => {
      this.adventureCurr = data
    })
  }

  cancelCottage(cottage: any){

  }

  cancelShip(ship: any){

  }

  cancelAdventure(adventure: any){

  }

  rateCottage(cottage: any){

  }

  rateShip(cottage: any){
    
  }

  rateAdventure(reservation: any){
    const ref = this.dialogService.open(DialogRating, {
      data: {
        reservation: reservation,
        clientId: this.currentUser.id,
      },
      width: 'auto',
      height: 'auto'
    });
    

    ref.onClose.subscribe((data) => {
      let params = {
        ownerRate: data.ownerRate,
        entityRate: data.entityRate,
        reservationId: data.reservationId,
        clientId: data.clientId,
        ownerId: data.ownerId,
        entityId: data.entityId,
        text: data.text,
        rated: data.isRated
      }
      this.resService.rateAdventure(data).subscribe(data => {
        console.log(data)
      })
    });
  }

}

@Component({
  templateUrl: 'dialogRating.html'
})
export class DialogRating {

  reservation: any;
  instructor: any;
  userId: any;
  text: string = "";
  rate1: number = 0;
  rate2: number = 0;

  constructor(public ref: DynamicDialogRef, public config: DynamicDialogConfig,
    private instructorService: InstructorHomePageService) { }

  ngOnInit() {
    this.reservation = this.config.data.reservation
    this.userId = this.config.data.clientId
    this.instructorService.getProfileInfo(this.reservation.ownerId).subscribe(data =>{
      this.instructor = data;
    })
  }

  close() {
    this.ref.close();
  }

  save() {
    let params = {
      ownerRate: this.rate1,
      entityRate: this.rate2,
      reservationId: this.reservation.id,
      clientId: this.userId,
      ownerId: this.instructor.id,
      entityId: this.reservation.entityId,
      text: this.text,
      rated: true
    }
    this.ref.close(params);
  }
}
