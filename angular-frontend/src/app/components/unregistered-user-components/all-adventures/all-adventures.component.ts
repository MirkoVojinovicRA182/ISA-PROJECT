import { Options } from '@angular-slider/ngx-slider';
import { analyzeAndValidateNgModules } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { async, Observable, take } from 'rxjs';
import { Instructor } from 'src/app/model/instructor';
import { InstructorHomePageService } from 'src/app/services/instructor-home-page/instructor-home-page.service';
import { InstructorLessonsService } from 'src/app/services/instructor-lessons/instructor-lessons.service';

@Component({
  selector: 'app-all-adventures',
  templateUrl: './all-adventures.component.html',
  styleUrls: ['./all-adventures.component.css']
})
export class AllAdventuresComponent implements OnInit {

  adventures: any;
  reshapedAdventures: any = [];
  instructor: Instructor = new Instructor();
  filteredAdventures: any;
  maxPrice: number = 0;
  nameFilter: string = "";
  addressFilter: string = "";
  instructorFilter: string = "";
  selectedPriceMin: number = 0;
  selectedPriceMax: number = 0;

  priceOptions: Options = {
    floor: 0,
    ceil: 0,
  };

  constructor(private adventureService: InstructorLessonsService, private router: Router,
    private instructorService: InstructorHomePageService) { }

  ngOnInit() {
    this.getAllAdventures()
  }

  getAllAdventures() {
    this.adventureService.getAllLessons().subscribe({
      next: adventures => {
        this.adventures = adventures
        this.filteredAdventures = this.adventures
        this.getMaxPrice()
        this.getInfoAboutAdventures(adventures)
      }
    });
  }

  getInfoAboutAdventures(adventures: any) {
    adventures.forEach((element: any) => {
      this.instructorService.getProfileInfo(element.instructorId).subscribe({
        next: response => {
          this.reshapedAdventures.push({
            adventure: element,
            instructor: response
          });
        }
      })
    });
  }

  getMaxPrice() {
    for (var adventure of this.adventures) {
      if (this.maxPrice < adventure?.price)
        this.maxPrice = adventure?.price;
    }
    this.selectedPriceMax = this.maxPrice;
    this.priceOptions = new Options();
    this.priceOptions.floor = 1;
    this.priceOptions.ceil = this.maxPrice;
  }

  filterAdventures() {
    let filteredAdventures = new Array();
    let includesFilter1 = false;
    let includesFilter2 = false;
    for (var adventure of this.reshapedAdventures) {
      let nameAndLastName = this.instructorFilter.split(' ')
      if (adventure.instructor?.name.toLowerCase().includes(nameAndLastName[0]?.toLowerCase())
        || adventure.instructor?.lastName.toLowerCase().includes(nameAndLastName[0]?.toLowerCase())
        || adventure.instructor?.name.toLowerCase().includes(nameAndLastName[1]?.toLowerCase())
        || adventure.instructor?.lastName.toLowerCase().includes(nameAndLastName[1]?.toLowerCase())) {
        includesFilter1 = true;
      }

      if (this.selectedPriceMin <= adventure.adventure?.price && adventure.adventure?.price <= this.selectedPriceMax
        && adventure.adventure?.name.toLowerCase().includes(this.nameFilter.toLowerCase())
        && adventure.adventure?.address.toLowerCase().includes(this.addressFilter.toLowerCase())) {
        includesFilter2 = true;
      }

      if (includesFilter1 && includesFilter2) {
        filteredAdventures.push(adventure)
        includesFilter1 = false;
        includesFilter2 = false;
      }
    }

    this.reshapedAdventures = filteredAdventures
    return this.maxPrice;
  }

  restartFilters() {
    this.selectedPriceMax = this.maxPrice;
    this.selectedPriceMin = 1;
    this.nameFilter = "";
    this.addressFilter = "";
    this.instructorFilter = "";
    this.reshapedAdventures = [];
    this.adventures = [];
    this.getAllAdventures();
  }

  public nameInputChange(filter: any) {
    this.nameFilter = filter;
  }

  public addressInputChange(filter: any) {
    this.addressFilter = filter;
  }

  public instructorInputChange(filter: any) {
    this.instructorFilter = filter;
  }

}
