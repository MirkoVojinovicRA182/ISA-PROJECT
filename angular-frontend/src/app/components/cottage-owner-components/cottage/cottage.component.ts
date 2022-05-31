import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { CottageEditComponent } from '../cottage-edit/cottage-edit.component';

@Component({
  selector: 'app-cottage',
  templateUrl: './cottage.component.html',
  styleUrls: ['./cottage.component.css']
})
export class CottageComponent implements OnInit {

  cottage: any;
  images = [
    {path: 'https://upload.wikimedia.org/wikipedia/commons/2/26/Church_Cottage%2C_Stretton_Grandison_-_geograph.org.uk_-_459243.jpg'},
    {path: 'https://upload.wikimedia.org/wikipedia/commons/2/26/Church_Cottage%2C_Stretton_Grandison_-_geograph.org.uk_-_459243.jpg'},
    {path: 'https://upload.wikimedia.org/wikipedia/commons/2/26/Church_Cottage%2C_Stretton_Grandison_-_geograph.org.uk_-_459243.jpg'},
    {path: 'https://upload.wikimedia.org/wikipedia/commons/2/26/Church_Cottage%2C_Stretton_Grandison_-_geograph.org.uk_-_459243.jpg'},
  ]
  
  constructor(private router: Router,  public detailsDialog: MatDialog) {
    var selectedCottage = localStorage.getItem('selectedCottage')
    if(selectedCottage != null)
      this.cottage = JSON.parse(selectedCottage)
  }

  ngOnInit(): void {
    window.scroll(0,0)
    this.images.push({path: 'https://upload.wikimedia.org/wikipedia/commons/2/26/Church_Cottage%2C_Stretton_Grandison_-_geograph.org.uk_-_459243.jpg'})
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

}
