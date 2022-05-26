import { Options } from '@angular-slider/ngx-slider';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { serverPort } from 'src/app/app.consts';
import { CottagesService } from 'src/app/services/cottages/cottages.service';

@Component({
  selector: 'app-cottages-preview',
  templateUrl: './cottages-preview.component.html',
  styleUrls: ['./cottages-preview.component.css']
})
export class CottagesPreviewComponent implements OnInit {

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
    ceil: 100,
  };

  bedsOptions: Options = {
    floor: 0,
    ceil: 100,
  };


  constructor(private cottageService: CottagesService, private router: Router) { }

  ngOnInit(): void {
    window.scroll(0,0)
    this.getUserCottages();
  }

  getUserCottages(){
    this.cottageService.getUserCottages(5).subscribe(
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
    if(this.cottages.rooms != null){
      this.maxRooms = this.cottages[0]?.roomsNumber;
      for (var cottage of this.cottages) {
        if(this.maxRooms < cottage?.rooms.lenght)
          this.maxRooms = cottage?.rooms.lenght;
      }
      this.selectedRoomsMax = this.maxRooms;
      this.roomsOptions = new Options();
      this.roomsOptions.floor = 1;
      this.roomsOptions.ceil = this.maxRooms;
    }
  }

  getMaxBeds(){
    if(this.cottages.rooms != null){
      this.maxBeds = this.cottages[0]?.rooms[0]?.bedsNumber;
      for (var cottage of this.cottages) {
        for(var room of cottage?.rooms){
          if(this.maxBeds < room?.bedsNumber)
            this.maxBeds = room?.bedsNumber;
        }
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
      if(this.selectedRoomsMin <= cottage?.rooms.lenght && cottage?.rooms.lenght <= this.selectedRoomsMax && 
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
  }

  getAllBedsNumber(cottage : any){
    var bedsNumber = 0;
    for(var room of cottage.rooms){
      bedsNumber += room.bedsNumber
    }
    return bedsNumber;
  }

  public nameInputChange(filter: any){
    this.nameFilter = filter;
  }

  public addressInputChange(filter: any){
    this.addressFilter = filter;
  }

  public cottageDetails(cottage: any){
    var selectedCottage = JSON.stringify(cottage)
    localStorage.setItem('selectedCottage', selectedCottage)
    this.router.navigate(['cottageOwner/cottageDetails'])
  }

  public editCottage(cottage: any){
    var selectedCottage = JSON.stringify(cottage)
    localStorage.setItem('selectedCottage', selectedCottage)
    this.router.navigate(['cottageOwner/cottageDetails'])
  }

}
