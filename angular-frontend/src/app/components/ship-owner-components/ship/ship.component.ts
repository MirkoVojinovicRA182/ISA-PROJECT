import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { ShipsService } from 'src/app/services/ships/ships.service';
import { ShipEditComponent } from '../ship-edit/ship-edit.component';

@Component({
  selector: 'app-ship',
  templateUrl: './ship.component.html',
  styleUrls: ['./ship.component.css']
})
export class ShipComponent implements OnInit {

  msg: string = "";
  addImages = new Array<any>();
  newImages:any;

  ship: any;
  images: any;

  constructor(private router: Router,  public detailsDialog: MatDialog, private shipsService: ShipsService) { }

  ngOnInit(): void {
    window.scroll(0,0)
    var selectedShip = localStorage.getItem('selectedShip')
    if(selectedShip != null){
      this.ship = JSON.parse(selectedShip)
    }
  }

  getImage(image: any){
    return image.url.split("/")[3]+"/"+image.url.split("/")[4]+"/"+image.url.split("/")[5]
  }

  showEditDialog(){
    const dialogRef = this.detailsDialog.open(ShipEditComponent, {
      data: this.ship,
      panelClass: 'backdropBackground',
      disableClose: false,
      width: '40%',
    });
    dialogRef.afterClosed().subscribe(ship => {
      console.log(ship)
    }
    );
  }

  showCalendar(){
    window.location.href = "/shipOwner/calendar"
  }

  deleteShip(){
    this.shipsService.deleteShip(this.ship.shipId).subscribe(() => {
      this.router.navigate(['/shipOwner/shipsPreview']);
    })
  }

  selectFile(event: any) {
    let data = new Array<any>();
    if (!event.target.files[0] || event.target.files[0].length == 0) {
      this.msg = 'You must select an image';
      return;
    }

    for (const singlefile of event.target.files) {
      var mimeType = singlefile.type;
      if (mimeType.match(/image\/*/) == null) {
        this.msg = "Only images are supported";
        alert(this.msg)
        return;
      }
      var reader = new FileReader();
      reader.readAsDataURL(singlefile); 
      reader.onload = (_event : any) => {
        this.msg = "";
        this.addImages.push(_event.target.result)
        let data2 = {
          cottageImageId: this.ship.images.length,
          url: this.ship.name + "-" + this.ship.shipId,
          base64: _event.target.result,
          cottageId: this.ship.shipId
        }
        data.push(data2);
        this.shipsService.addImages(data).subscribe( data => {this.ship = data
          localStorage.setItem('selectedShip', JSON.stringify(this.ship));
          window.location.reload();})
      }
    };
  }

}
