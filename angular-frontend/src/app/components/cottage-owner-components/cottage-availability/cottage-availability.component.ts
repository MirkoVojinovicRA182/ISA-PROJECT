import { formatDate } from '@angular/common';
import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { CottagesService } from 'src/app/services/cottages/cottages.service';

@Component({
  selector: 'app-cottage-availability',
  templateUrl: './cottage-availability.component.html',
  styleUrls: ['./cottage-availability.component.css']
})
export class CottageAvailabilityComponent{

  showNewAvailability: boolean = false;
  availabilities: any;
  availability: any;

  constructor(public dialogRef: MatDialogRef<CottageAvailabilityComponent>, @Inject(MAT_DIALOG_DATA) public data: any, private cottageService: CottagesService) {
    data.cottageAvailability = this.sortData()
    this.availability = {availabilityId: 0, cottageId: data.cottageId, startDate: "", endDate: ""}
    this.availabilities = [];
   }

   datePrint(date: any){
     return formatDate(date, 'dd.MM.yyyy', 'en-US')
   }

   sortData() {
    return this.data.cottageAvailability.sort((a: { startDate: string | number | Date; }, b: { startDate: string | number | Date; }) => {
      return <any>new Date(a.startDate) - <any>new Date(b.startDate);
    });
  }

  addAvailability(event: any){
    this.showNewAvailability = !this.showNewAvailability;
    if(event.textContent == "New availability"){
      event.textContent = "Save availability"
    }else{
      let availabilityData = Object.assign({}, this.availability);
      this.availabilities.push(availabilityData);
      this.cottageService.addAvailability(this.availabilities).subscribe();
      event.textContent = "New availability"
    }
  }

  addNewAvailability(){
    this.cottageService.addAvailability(this.availabilities).subscribe( returnData => 
      {localStorage.setItem("selectedCottage", JSON.stringify(returnData)), window.location.reload()});
  }

  deleteAvailability(id: number, index: number){
    this.data.cottageAvailability.splice(index, 1);
    this.cottageService.removeAvailability(id).subscribe()
  }

}
