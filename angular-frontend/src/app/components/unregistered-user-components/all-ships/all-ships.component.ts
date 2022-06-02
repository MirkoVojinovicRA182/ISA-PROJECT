import { Options } from '@angular-slider/ngx-slider';
import { Component, Input, OnInit } from '@angular/core';
import { DateFilterFn } from '@angular/material/datepicker';
import { Router } from '@angular/router';
import { ShipsService } from 'src/app/services/ships/ships.service';

@Component({
  selector: 'app-all-ships',
  templateUrl: './all-ships.component.html',
  styleUrls: ['./all-ships.component.css']
})
export class AllShipsComponent implements OnInit {

  ships: any;
  filteredShips: any;
  maxPrice!: number;
  nameFilter: string = "";
  addressFilter: string = "";
  selectedPriceMin: number = 0;
  selectedPriceMax: number = 0;

  priceOptions: Options = {
    floor: 0,
    ceil: 0,
  };

  constructor(private shipService: ShipsService, private router: Router) { }

  ngOnInit(): void {
    this.getAllShips();
  }

  getAllShips() {
    this.shipService.getAllShips().subscribe(
      ships => {
        this.ships = ships,
          this.filteredShips = ships,
          this.getMaxPrice()
      }
    );
  }

  getMaxPrice() {
    this.maxPrice = this.ships[0]?.roomsNumber;
    for (var ship of this.ships) {
      if (this.maxPrice < ship?.price)
        this.maxPrice = ship?.price;
    }
    this.selectedPriceMax = this.maxPrice;
    this.priceOptions = new Options();
    this.priceOptions.floor = 1;
    this.priceOptions.ceil = this.maxPrice;
  }

  filterCottages() {
    this.filteredShips = new Array();
    for (var ship of this.ships) {
      /*if(this.selectedRoomsMin <= cottage?.roomsNumber && cottage?.roomsNumber <= this.selectedRoomsMax && 
        this.selectedBedsMin <= cottage?.bedsNumber && cottage?.bedsNumber <= this.selectedBedsMax &&
        cottage?.name.toLowerCase().includes(this.nameFilter.toLowerCase()) && cottage?.address.toLowerCase().includes(this.addressFilter.toLowerCase()))
        this.filteredCottages.push(cottage)*/
    }
    return this.maxPrice;
  }

  restartFilters() {
    this.selectedPriceMax = this.maxPrice;
    this.selectedPriceMin = 1;
    this.nameFilter = "";
    this.addressFilter = "";
  }

  public nameInputChange(filter: any) {
    this.nameFilter = filter;
  }

  public addressInputChange(filter: any) {
    this.addressFilter = filter;
  }
}
