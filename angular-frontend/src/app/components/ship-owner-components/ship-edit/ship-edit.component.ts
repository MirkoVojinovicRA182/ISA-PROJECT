import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ShipsService } from 'src/app/services/ships/ships.service';

@Component({
  selector: 'app-ship-edit',
  templateUrl: './ship-edit.component.html',
  styleUrls: ['./ship-edit.component.css']
})
export class ShipEditComponent {

  ship: any;

  constructor(public dialogRef: MatDialogRef<ShipEditComponent>, @Inject(MAT_DIALOG_DATA) public data: any, private shipsService: ShipsService) {
    this.ship = Object.assign({}, data) 
  }

  change(){
    let shipForUpdate = {
      shipId : this.ship.shipId,
      name: this.ship.name,
      address: this.ship.address,
      promotiveDescription: this.ship.promotiveDescription,
      conductRules: this.ship.conductRules,
      pricelist: this.ship.pricelist,
      shipOwnerId: this.ship.shipOwnerId,
      type: this.ship.type,
      lenght: this.ship.lenght,
      engineNumber: this.ship.engineNumber,
      enginePower: this.ship.enginePower,
      maxSpeed: this.ship.maxSpeed,
      capacity: this.ship.capacity,
      additionalServicesInfo: this.ship.additionalServicesInfo,
      cancellationPolicy: this.ship.cancellationPolicy,
    }
    this.shipsService.updateShip(shipForUpdate).subscribe( data => {localStorage.setItem('selectedShip', JSON.stringify(data)); window.location.reload()})
  }

  getImage(image: any){
    return image.url.split("/")[3]+"/"+image.url.split("/")[4]+"/"+image.url.split("/")[5]
  }

  removeImage(image: any){
    let data = {
      cottageImageid: image.id,
      url: image.url,
      cottageId: this.ship.shipId
    }
    this.shipsService.removeImage(data).subscribe( returnData => { this.ship = returnData, data = returnData,
      localStorage.setItem('selectedShip', JSON.stringify(returnData)); window.location.reload()})
  }

}
