import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DialogService, DynamicDialogConfig, DynamicDialogRef } from 'primeng/dynamicdialog';
import { Cottage } from 'src/app/model/cottage';
import { InstructorHomePageService } from 'src/app/services/instructor-home-page/instructor-home-page.service';
import { ReservationsService } from 'src/app/services/reservations/reservations.service';
import { UserProfileService } from 'src/app/services/user-profile/user-profile.service';

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

  date: Date = new Date();

  shipRes: any;
  shipCurr: any;

  currentUser: any;

  constructor(private resService: ReservationsService,
    public dialogService: DialogService,
    private router: Router) { }

  ngOnInit(): void {
    let user = localStorage.getItem('currentUser')
    if (user != null) {
      this.currentUser = JSON.parse(user)
    }
    this.getAll()
    this.date.setDate(this.date.getDate() + 3);
    
  }

  canCancel(date: any){
    let date2 = new Date(date)
    if(date2.getTime() > this.date.getTime()){
      return true
    }
    return false
  }

  getAll() {
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

  cancelCottage(cottage: any) {
    this.resService.cancelCottageReservation(cottage.id).subscribe(() => {
      this.cottageCurr.delete(cottage)
    })
    let date = new Date(cottage.date)
    if(date.getTime() > this.date.getTime()){
      console.log("da")
    }
    window.location.reload();
  }

  cancelShip(ship: any) {
    this.resService.cancelShipReservation(ship.shipId).subscribe(() => {
      this.shipCurr.delete(ship)
    })
    this.resService.getShipCurrentReservationByClientId(this.currentUser.id).subscribe(data => {
      this.shipCurr = data
    })
  }

  cancelAdventure(adventure: any) {
    this.resService.cancelAdventureReservation(adventure.id).subscribe(() => {
      this.adventureCurr.delete(adventure)
    })
    this.resService.getAdventureCurrentReservationByClientId(this.currentUser.id).subscribe(data => {
      this.adventureCurr = data
    })
  }

  rateCottage(reservation: any) {
    const ref = this.dialogService.open(DialogCottageRating, {
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
      this.resService.rateCottage(data).subscribe(data => {
        console.log(data)
      })
    });
  }

  rateShip(reservation: any) {
    const ref = this.dialogService.open(DialogShipRating, {
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
      this.resService.rateShip(data).subscribe(data => {
        console.log(data)
      })
    });
  }

  rateAdventure(reservation: any) {
    const ref = this.dialogService.open(DialogAdventureRating, {
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

  complaintCottage(reservation: any) {
    const ref = this.dialogService.open(DialogCottageComplaint, {
      data: {
        reservation: reservation,
        clientId: this.currentUser.id,
      },
      width: 'auto',
      height: 'auto'
    });


    ref.onClose.subscribe((data) => {
      let params = {
        clientId: data.userId,
        ownerId: data.ownerId,
        entityId: data.entityId,
        text: data.text,
      }
      this.resService.complaintCottage(data).subscribe(data => {
        console.log(data)
      })
    });
  }
  complaintShip(reservation: any) {
    const ref = this.dialogService.open(DialogShipComplaint, {
      data: {
        reservation: reservation,
        clientId: this.currentUser.id,
      },
      width: 'auto',
      height: 'auto'
    });


    ref.onClose.subscribe((data) => {
      let params = {
        clientId: data.userId,
        ownerId: data.ownerId,
        entityId: data.entityId,
        text: data.text,
      }
      this.resService.complaintShip(data).subscribe(data => {
        console.log(data)
      })
    });
  }
  complaintAdventure(reservation: any) {
    const ref = this.dialogService.open(DialogAdventureComplaint, {
      data: {
        reservation: reservation,
        clientId: this.currentUser.id,
      },
      width: 'auto',
      height: 'auto'
    });


    ref.onClose.subscribe((data) => {
      let params = {
        clientId: data.userId,
        ownerId: data.ownerId,
        entityId: data.entityId,
        text: data.text,
      }
      this.resService.complaintAdventure(data).subscribe(data => {
        console.log(data)
      })
    });
  }

}

@Component({
  templateUrl: 'dialogAdventureRating.html'
})
export class DialogAdventureRating {

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
    this.instructorService.getProfileInfo(this.reservation.ownerId).subscribe(data => {
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

@Component({
  templateUrl: 'dialogCottageRating.html'
})
export class DialogCottageRating {

  reservation: any;
  cottageOwner: any;
  userId: any;
  text: string = "";
  rate1: number = 0;
  rate2: number = 0;

  constructor(public ref: DynamicDialogRef, public config: DynamicDialogConfig,
    private cottageOwnerService: UserProfileService) { }

  ngOnInit() {
    this.reservation = this.config.data.reservation
    this.userId = this.config.data.clientId
    this.cottageOwnerService.getCottageOwnerById(this.reservation.ownerId).subscribe(data => {
      this.cottageOwner = data;
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
      ownerId: this.cottageOwner.id,
      entityId: this.reservation.entityId,
      text: this.text,
      rated: true
    }
    this.ref.close(params);
  }
}

@Component({
  templateUrl: 'dialogShipRating.html'
})
export class DialogShipRating {

  reservation: any;
  shipOwner: any;
  userId: any;
  text: string = "";
  rate1: number = 0;
  rate2: number = 0;

  constructor(public ref: DynamicDialogRef, public config: DynamicDialogConfig,
    private shipOwnerService: UserProfileService) { }

  ngOnInit() {
    this.reservation = this.config.data.reservation
    this.userId = this.config.data.clientId
    this.shipOwnerService.getShipOwner(this.reservation.ownerId).subscribe(data => {
      this.shipOwner = data;
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
      ownerId: this.shipOwner.id,
      entityId: this.reservation.entityId,
      text: this.text,
      rated: true
    }
    this.ref.close(params);
  }
}


//COMPLAINT
@Component({
  templateUrl: 'dialogCottageComplaint.html'
})
export class DialogCottageComplaint {

  reservation: any;
  userId: any;
  text: string = "";

  constructor(public ref: DynamicDialogRef, public config: DynamicDialogConfig,
    private shipOwnerService: UserProfileService) { }

  ngOnInit() {
    this.reservation = this.config.data.reservation
    this.userId = this.config.data.clientId
  }

  close() {
    this.ref.close();
  }

  save() {
    let params = {
      clientId: this.userId,
      ownerId: this.reservation.ownerId,
      entityId: this.reservation.entityId,
      text: this.text,
    }
    this.ref.close(params);
  }
}

@Component({
  templateUrl: 'dialogShipComplaint.html'
})
export class DialogShipComplaint {

  reservation: any;
  userId: any;
  text: string = "";

  constructor(public ref: DynamicDialogRef, public config: DynamicDialogConfig,
    private shipOwnerService: UserProfileService) { }

  ngOnInit() {
    this.reservation = this.config.data.reservation
    this.userId = this.config.data.clientId
  }

  close() {
    this.ref.close();
  }

  save() {
    let params = {
      clientId: this.userId,
      ownerId: this.reservation.ownerId,
      entityId: this.reservation.entityId,
      text: this.text,
    }
    this.ref.close(params);
  }
}

@Component({
  templateUrl: 'dialogAdventureComplaint.html'
})
export class DialogAdventureComplaint {

  reservation: any;
  userId: any;
  text: string = "";

  constructor(public ref: DynamicDialogRef, public config: DynamicDialogConfig,
    private shipOwnerService: UserProfileService) { }

  ngOnInit() {
    this.reservation = this.config.data.reservation
    this.userId = this.config.data.clientId
  }

  close() {
    this.ref.close();
  }

  save() {
    let params = {
      clientId: this.userId,
      ownerId: this.reservation.ownerId,
      entityId: this.reservation.entityId,
      text: this.text,
    }
    this.ref.close(params);
  }
}



