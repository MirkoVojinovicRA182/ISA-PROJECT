import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { CottageEditComponent } from '../cottage-edit/cottage-edit.component';
import * as FileSaver from 'file-saver';
import { CottagesService } from 'src/app/services/cottages/cottages.service';

@Component({
  selector: 'app-cottage',
  templateUrl: './cottage.component.html',
  styleUrls: ['./cottage.component.css']
})
export class CottageComponent implements OnInit {

  msg: string = "";
  addImages = new Array<any>();
  newImages:any;

  cottage: any;
  images: any;
  
  constructor(private router: Router,  public detailsDialog: MatDialog, private cottageService: CottagesService) {
  }

  ngOnInit(): void {
    window.scroll(0,0)
    var selectedCottage = localStorage.getItem('selectedCottage')
    if(selectedCottage != null){
      this.cottage = JSON.parse(selectedCottage)
    }
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

}
