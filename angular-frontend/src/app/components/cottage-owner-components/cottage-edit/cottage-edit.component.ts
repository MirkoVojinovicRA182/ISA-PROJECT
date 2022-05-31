import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { CottagesService } from 'src/app/services/cottages/cottages.service';

@Component({
  selector: 'app-cottage-edit',
  templateUrl: './cottage-edit.component.html',
  styleUrls: ['./cottage-edit.component.css']
})
export class CottageEditComponent{

  cottage: any;
  
  constructor(public dialogRef: MatDialogRef<CottageEditComponent>, @Inject(MAT_DIALOG_DATA) public data: any, private cottageService: CottagesService) {
    this.cottage = Object.assign({}, data);
  }

  change(){
    let cottageForUpdate = {
      cottageId : this.cottage.cottageId,
      name: this.cottage.name,
      address: this.cottage.address,
      promotiveDescription: this.cottage.promotiveDescription,
      conductRules: this.cottage.conductRules,
      pricelist: this.cottage.pricelist,
      cottageOwnerId: this.cottage.cottageOwnerId,
    }
    this.cottageService.updateCottage(cottageForUpdate).subscribe()
  }

}
