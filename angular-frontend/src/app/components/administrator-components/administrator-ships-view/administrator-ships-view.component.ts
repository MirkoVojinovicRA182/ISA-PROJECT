import { Component, OnInit } from '@angular/core';
import { AdministratorEntitiesService } from 'src/app/services/administrator-entities/administrator-entities.service';

@Component({
  selector: 'app-administrator-ships-view',
  templateUrl: './administrator-ships-view.component.html',
  styleUrls: ['./administrator-ships-view.component.css']
})
export class AdministratorShipsViewComponent implements OnInit {

  searchValue: string = "";
  ships: any

  constructor(private entitesService: AdministratorEntitiesService) { }

  ngOnInit(): void {
    this.getShips();
  }

  getShips(){
    this.entitesService.getAllShips().subscribe(ships => this.ships = ships);
  }

  findShip(){
   this.entitesService.getAllShips().subscribe(
     cottages =>{
       this.ships = cottages;
       let foundedShips = [];

       for(let ship of this.ships)
        if(ship.name.toLocaleLowerCase().includes(this.searchValue.toLocaleLowerCase()))
        foundedShips.push(ship);

        this.ships = foundedShips;
     }
   )
  }

  deleteShip(shipId: any){
    this.entitesService.deleteShip(shipId).subscribe(() => this.getShips());
  }


}
