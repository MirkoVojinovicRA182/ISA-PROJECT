import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { CottagesService } from 'src/app/services/cottages/cottages.service';

@Component({
  selector: 'app-new-cottage',
  templateUrl: './new-cottage.component.html',
  styleUrls: ['./new-cottage.component.css']
})
export class NewCottageComponent{

  cottage: any;
  showRoom: boolean = false;
  showAvailability: boolean = false;
  images: any;
  rooms: any;
  room: any;
  availabilities: any;
  availability: any;

  constructor(public dialogRef: MatDialogRef<NewCottageComponent>, @Inject(MAT_DIALOG_DATA) public data: any, private cottageService: CottagesService) { 
    this.cottage = {
      cottageId: 0,
      name: "",
      address: "",
      promotiveDescription: "",
      conductRules: "",
      pricelist: "",
      cottageOwnerId: data,
    }
    this.rooms = [];
    this.images = [];
    this.availabilities = [];
    this.room = {roomId: 0, roomNumber: 1, bedsNumber: 2, bathroom: true, clime: false, cottageId: 0}
    this.availability = {availabilityId: 0, cottageId: 0, startDate: "", endDate: ""}
  }

  addRoom(event:any){
    this.showRoom = !this.showRoom
    if(event.textContent == "Add room"){
      event.textContent = "Save room"
    }else{
      let roomData = Object.assign({}, this.room);
      this.rooms.push(roomData);
      event.textContent = "Add room"
    }
  }

  addNewCottage(){
    this.cottageService.addNewCottage(this.cottage).subscribe((data) => {
      for(let i = 0; i < this.rooms.length; i++){
        this.rooms[i].cottageId = data.cottageId;
      }
      for(let i = 0; i < this.images.length; i++){
        this.images[i].cottageId = data.cottageId;
        this.images[i].url = data.name + "-" + data.cottageId;
      }
      for(let i = 0; i < this.availabilities.length; i++){
        this.availabilities[i].cottageId = data.cottageId;
      }
      this.cottageService.addRoom(this.rooms).subscribe();
      this.cottageService.addImages(this.images).subscribe();
      this.cottageService.addAvailability(this.availabilities).subscribe();
      window.location.reload()
    });
  }

  addAvailability(event:any){
    this.showAvailability = !this.showAvailability
    if(event.textContent == "Add availability"){
      event.textContent = "Save availability"
    }else{
      let availabilityData = Object.assign({}, this.availability);
      this.availabilities.push(availabilityData);
      event.textContent = "Add availability"
    }
  }

  selectFile(event: any) {
      var reader = new FileReader();
      reader.readAsDataURL(event.target.files[0]); 
      reader.onload = (_event : any) => {
        let data2 = {
          cottageImageId: this.images?.length,
          url: this.cottage.name + "-" + this.cottage.cottageId,
          base64: _event.target.result,
          cottageId: this.cottage.cottageId
        }
        this.images.push(data2)
      }
  }

}
