import { Component, OnInit } from '@angular/core';
import { ReservationsService } from 'src/app/services/reservations/reservations.service';

@Component({
  selector: 'app-client-history',
  templateUrl: './client-history.component.html',
  styleUrls: ['./client-history.component.css']
})
export class ClientHistoryComponent implements OnInit {

  cottageRes: any;
  cottageCurr: any;

  adventureRes: any;
  adventureCurr: any;

  shipRes: any;
  shipCurr: any;

  currentUser: any;

  constructor(private resService: ReservationsService) { }

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

  rateAdventure(cottage: any){
    
  }

}
