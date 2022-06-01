import { Component, OnInit } from '@angular/core';
import { Options } from '@angular-slider/ngx-slider';
import { ActivatedRoute, Router } from '@angular/router';
import { Cottage } from 'src/app/model/cottage';
import { CottagesService } from 'src/app/services/cottages/cottages.service';

@Component({
  selector: 'allCottages',
  templateUrl: './all-cottages.component.html',
  styleUrls: ['./all-cottages.component.css']
})
export class AllCottagesComponent implements OnInit {

  cottages: any;
  filteredCottages: any;
  maxRooms!: number;
  maxBeds!: number;
  nameFilter: string = "";
  addressFilter: string = "";
  selectedRoomsMin: number = 0;
  selectedRoomsMax: number = 0;
  selectedBedsMin: number = 0;
  selectedBedsMax: number = 0;

  roomsOptions: Options = {
    floor: 0,
    ceil: 0,
  };

  bedsOptions: Options = {
    floor: 0,
    ceil: 0,
  };


  constructor(private cottageService: CottagesService, private router: Router, private activeRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.getAllCottages();
  }

  getAllCottages(){
    this.cottageService.getAllCottages().subscribe(
      cottages => {
        this.cottages = cottages,
        this.filteredCottages = cottages,
        this.getMaxRooms(),
        this.getMaxBeds()
      }
    );
  }

  showCottageDetails(cottage: any){
    this.router.navigate(["cottageOwner/cottageDetails"], { state: { data:cottage }});

    /*this.router.navigateByUrl("cottageOwner/cottageDetails", {
           state: {data:cottage}
       });*/
  }

  getMaxRooms(){
    if(this.cottages.rooms !== null){
      this.maxRooms = this.cottages[0].rooms.length;
      for (var cottage of this.cottages) {
        if(this.maxRooms < cottage?.rooms.length)
          this.maxRooms = cottage?.rooms.length;
      }
      this.selectedRoomsMax = this.maxRooms;
      this.roomsOptions = new Options();
      this.roomsOptions.floor = 1;
      this.roomsOptions.ceil = this.maxRooms;
    }
  }

  getMaxBeds(){
    if(this.cottages.rooms !== null){
      this.maxBeds = this.getAllBedsNumber(this.cottages[0]);
      for (var cottage of this.cottages) {
        if(this.maxBeds < this.getAllBedsNumber(cottage))
          this.maxBeds = this.getAllBedsNumber(cottage)
      }
      this.selectedBedsMax = this.maxBeds;
      this.bedsOptions = new Options();
      this.bedsOptions.floor = 1;
      this.bedsOptions.ceil = this.maxBeds;
    }
  }

  filterCottages(){
    this.filteredCottages = new Array();
    for (var cottage of this.cottages) {
      if(this.selectedRoomsMin <= cottage?.rooms.length && cottage?.rooms.length <= this.selectedRoomsMax && 
        this.selectedBedsMin <= this.getAllBedsNumber(cottage) && this.getAllBedsNumber(cottage) <= this.selectedBedsMax &&
        cottage?.name.toLowerCase().includes(this.nameFilter.toLowerCase()) && cottage?.address.toLowerCase().includes(this.addressFilter.toLowerCase()))
        this.filteredCottages.push(cottage)
    }
    return this.maxRooms;
  }

  restartFilters(){
    this.selectedBedsMax = this.maxBeds;
    this.selectedRoomsMax = this.maxRooms;
    this.selectedBedsMin = 1;
    this.selectedRoomsMin = 1;
    this.nameFilter = "";
    this.addressFilter = "";
    this.filteredCottages = this.cottages;
  }

  public nameInputChange(filter: any){
    this.nameFilter = filter;
  }

  public addressInputChange(filter: any){
    this.addressFilter = filter;
  }

  getAllBedsNumber(cottage : any){
    var bedsNumber = 0;
    for(var room of cottage.rooms){
      bedsNumber += room.bedsNumber
    }
    return bedsNumber;
  }

}
