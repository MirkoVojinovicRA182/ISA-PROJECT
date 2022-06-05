import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { Subscription } from 'src/app/model/subscription';
import { ClientService } from 'src/app/services/client/client.service';
import { CottagesService } from 'src/app/services/cottages/cottages.service';
import { CottageAvailabilityComponent } from '../../cottage-owner-components/cottage-availability/cottage-availability.component';
import { CottageEditComponent } from '../../cottage-owner-components/cottage-edit/cottage-edit.component';

@Component({
  selector: 'app-client-cottage',
  templateUrl: './client-cottage.component.html',
  styleUrls: ['./client-cottage.component.css']
})
export class ClientCottageComponent implements OnInit {

  msg: string = "";
  addImages = new Array<any>();
  newImages:any;

  cottage: any;
  images: any;
  cottageOwner: any;
  currentUser: any;

  checkedCottage: boolean = true;
  checkedCottageOwner: boolean = true;
  
  constructor(private router: Router,  
    public detailsDialog: MatDialog, 
    private cottageService: CottagesService,
    private clientService: ClientService) {}

  ngOnInit(): void {
    window.scroll(0,0)
    var selectedCottage = localStorage.getItem('selectedCottage')
    let currentUser = localStorage.getItem('currentUser')
    if(currentUser != null){
      this.currentUser = JSON.parse(currentUser)
    }
    if(selectedCottage != null){
      this.cottage = JSON.parse(selectedCottage)
      this.clientService.getCottageOwnerById(this.cottage.cottageOwnerId).subscribe(data => {
        this.cottageOwner = data
      })
    }
    let subcription: Subscription = {
      id: -1,
      clientId: this.currentUser.id,
      subscribedTo: this.cottage.cottageOwnerId
    };
    this.clientService.isSubscribedToUser(subcription).subscribe(data => {
      if(data == true){
        this.checkedCottageOwner = false
      }
    })
    let subcription2: Subscription = {
      id: -1,
      clientId: this.currentUser.id,
      subscribedTo: this.cottage.cottageId
    };
    this.clientService.isSubscribedToCottage(subcription2).subscribe(data => {
      if(data == true){
        this.checkedCottage = false
      }
    })
  }

  getImage(image: any){
    return image.url.split("/")[3]+"/"+image.url.split("/")[4]+"/"+image.url.split("/")[5]
  }

  showEditDialog(){
    const dialogRef = this.detailsDialog.open(CottageEditComponent, {
      data: this.cottage,
      panelClass: 'backdropBackground',
      disableClose: false,
      width: '40%',
    });
    dialogRef.afterClosed().subscribe(cottage => {
      console.log(cottage)
    }
    );
  }

  showAvailability(){
    const dialogRef = this.detailsDialog.open(CottageAvailabilityComponent, {
      data: this.cottage,
      panelClass: 'backdropBackground',
      disableClose: false,
      width: '40%',
      maxHeight: '60vh',
    });
    dialogRef.afterClosed().subscribe(() => {
      this.cottageService.getCottageById(this.cottage.cottageId).subscribe(returnData => {
        localStorage.setItem('selectedCottage', JSON.stringify(returnData))
        this.cottage = returnData
        window.location.reload()
      })
    }
    )
  }

  deleteCottage(){
    this.cottageService.deleteCottage(this.cottage.cottageId).subscribe(data => {
      this.router.navigate(['/cottageOwner/cottagesPreview']);
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
          cottageImageId: this.cottage.images.length,
          url: this.cottage.name + "-" + this.cottage.cottageId,
          base64: _event.target.result,
          cottageId: this.cottage.cottageId
        }
        data.push(data2);
        this.cottageService.addImages(data).subscribe( data => {this.cottage = data
          localStorage.setItem('selectedCottage', JSON.stringify(this.cottage));
          window.location.reload();})
      }
    };
  }

  subscribeUser(){
    let subcription: Subscription = new Subscription();
      subcription.clientId = this.currentUser.id;
      subcription.subscribedTo = this.cottageOwner.id;
    if (!this.checkedCottageOwner){
      this.clientService.userSubscribe(subcription).subscribe()
      return
    }
    this.clientService.userUnSubscribe(subcription).subscribe()
  }

  subscribeCottage(){
    let subcription: Subscription = new Subscription();
      subcription.clientId = this.currentUser.id;
      subcription.subscribedTo = this.cottage.cottageId;
    if (!this.checkedCottage){
      this.clientService.cottageSubscribe(subcription).subscribe()
      return
    }
    this.clientService.cottageUnSubscribe(subcription).subscribe()
  }

}
