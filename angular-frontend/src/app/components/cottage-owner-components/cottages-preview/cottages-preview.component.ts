import { Options } from '@angular-slider/ngx-slider';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import jwtDecode from 'jwt-decode';
import { Observable } from 'rxjs';
import { serverPort } from 'src/app/app.consts';
import { CottagesService } from 'src/app/services/cottages/cottages.service';
import { CottageEditComponent } from '../cottage-edit/cottage-edit.component';

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
  cottageOwnerEmail: string = "";

  roomsOptions: Options = {
    floor: 0,
    ceil: 0,
  };

  bedsOptions: Options = {
    floor: 0,
    ceil: 0,
  };


  constructor(private cottageService: CottagesService, private router: Router) { }

  ngOnInit(): void {
    window.scroll(0,0)
    var token = localStorage.getItem('token');
    if(token != null){
      this.cottageOwnerEmail = jwtDecode<any>(JSON.parse(token).accessToken).sub;
    }
    this.getUserCottages(this.cottageOwnerEmail);
  }

  getUserCottages(username: string){
    this.cottageService.getUserCottages(username).subscribe(
      cottages => {
        this.cottages = cottages
        this.filteredCottages = cottages
        this.getMaxRooms()
        this.getMaxBeds()
      }
    );
  }

  showCottageDetails(cottage: any){
    this.router.navigate(["cottageOwner/cottageDetails"], { state: { data:cottage }});
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
