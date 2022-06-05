import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'src/app/model/subscription';
import { AdministratorEntitiesService } from 'src/app/services/administrator-entities/administrator-entities.service';
import { ClientService } from 'src/app/services/client/client.service';
import { UserProfileService } from 'src/app/services/user-profile/user-profile.service';

@Component({
  selector: 'app-client-ship',
  templateUrl: './client-ship.component.html',
  styleUrls: ['./client-ship.component.css']
})
export class ClientShipComponent implements OnInit {

  ship: any;
  shipOwner: any;
  currentUser: any;

  checkedShip: boolean = true;
  checkedShipOwner: boolean = true;
  
  constructor(private router: Router,  
    private clientService: ClientService,
    private userProfileService: UserProfileService) {}

  ngOnInit(): void {
    window.scroll(0,0)
    var selectedShip = localStorage.getItem('selectedShip')
    let currentUser = localStorage.getItem('currentUser')
    if(currentUser != null){
      this.currentUser = JSON.parse(currentUser)
    }
    if(selectedShip != null){
      this.ship = JSON.parse(selectedShip)
      this.userProfileService.getShipOwner(this.ship.shipOwnerId).subscribe(data => {
        this.shipOwner = data
      })
    }
    let subcription: Subscription = {
      id: -1,
      clientId: this.currentUser.id,
      subscribedTo: this.ship.shipOwnerId
    };
    this.clientService.isSubscribedToUser(subcription).subscribe(data => {
      if(data == true){
        this.checkedShipOwner = false
      }
    })
    let subcription2: Subscription = {
      id: -1,
      clientId: this.currentUser.id,
      subscribedTo: this.ship.shipId
    };
    this.clientService.isSubscribedToShip(subcription2).subscribe(data => {
      if(data == true){
        this.checkedShip = false
      }
    })

  }

  subscribeUser(){
    let subcription: Subscription = new Subscription();
      subcription.clientId = this.currentUser.id;
      subcription.subscribedTo = this.shipOwner.id;
    if (!this.checkedShipOwner){
      this.clientService.userSubscribe(subcription).subscribe()
      return
    }
    this.clientService.userUnSubscribe(subcription).subscribe()
  }

  subscribeShip(){
    let subcription: Subscription = new Subscription();
      subcription.clientId = this.currentUser.id;
      subcription.subscribedTo = this.ship.shipId;
    if (!this.checkedShip){
      this.clientService.shipSubscribe(subcription).subscribe()
      return
    }
    this.clientService.shipUnSubscribe(subcription).subscribe()
  }

}
