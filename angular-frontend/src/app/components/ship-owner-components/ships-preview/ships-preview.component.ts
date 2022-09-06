import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { ShipsService } from 'src/app/services/ships/ships.service';
import { NewShipComponent } from '../new-ship/new-ship.component';

@Component({
  selector: 'app-ships-preview',
  templateUrl: './ships-preview.component.html',
  styleUrls: ['./ships-preview.component.css']
})
export class ShipsPreviewComponent implements OnInit {

  ships: any;
  filteredShips: any;
  nameFilter: string = "";
  addressFilter: string = "";

  constructor(private router: Router, public detailsDialog: MatDialog, private shipsService: ShipsService) { }

  ngOnInit(): void {
    var currentUser: any = localStorage.getItem('currentUser')
    if(currentUser != null){
      currentUser = JSON.parse(currentUser)
      this.shipsService.getUsersShips(currentUser.id).subscribe(
        dataShips => {this.ships = dataShips,
        this.filteredShips = dataShips}
      )
    }
  }

  filterShips(){
    this.filteredShips = new Array();
    for (var ship of this.ships) {
      if(ship?.name.toLowerCase().includes(this.nameFilter.toLowerCase()) && ship?.address.toLowerCase().includes(this.addressFilter.toLowerCase()))
        this.filteredShips.push(ship)
    }
  }

  restartFilters(){
    this.nameFilter = "";
    this.addressFilter = "";
    this.filteredShips = this.ships;
  }

  public nameInputChange(filter: any){
    this.nameFilter = filter;
  }

  public addressInputChange(filter: any){
    this.addressFilter = filter;
  }

  public shipDetails(cottage: any){
    var selectedCottage = JSON.stringify(cottage)
    localStorage.setItem('selectedCottage', selectedCottage)
    this.router.navigate(['cottageOwner/cottageDetails'])
  }

  addNewShipDialog(){
    let storage = localStorage.getItem('currentUser');
    let currentUser
    if(storage != null)
      currentUser = JSON.parse(storage)
    else
      currentUser = {id: 0}
    const dialogRef = this.detailsDialog.open(NewShipComponent, {
      data: currentUser.id,
      panelClass: 'backdropBackground',
      disableClose: false,
      width: '40%',
    });
    dialogRef.afterClosed().subscribe(() => {
      console.log("zatvoreno")
    }
    );
  }

}
