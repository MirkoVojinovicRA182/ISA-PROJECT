import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ShipsService } from 'src/app/services/ships/ships.service';

@Component({
  selector: 'app-new-ship',
  templateUrl: './new-ship.component.html',
  styleUrls: ['./new-ship.component.css']
})
export class NewShipComponent implements OnInit {

  ship: any;

  constructor(public dialogRef: MatDialogRef<NewShipComponent>, @Inject(MAT_DIALOG_DATA) public data: any, private shipService: ShipsService) { }

  ngOnInit(): void {
    this.ship = {
      shipId: 0,
      name: "",
      type: "",
      lenght: 0,
      engineNumber: 1,
      enginePower: 1,
      maxSpeed: 100,
      capacity: 5,
      address: "",
      additionalServicesInfo: "",
      cancellationPolicy: "",
      promotiveDescription: "",
      conductRules: "",
      pricelist: 50,
      shipOwnerId: this.data,
    }
  }

  addNewShip(){
    this.shipService.createShip(this.ship).subscribe( () => {
      window.location.reload()
    });
  }

}
