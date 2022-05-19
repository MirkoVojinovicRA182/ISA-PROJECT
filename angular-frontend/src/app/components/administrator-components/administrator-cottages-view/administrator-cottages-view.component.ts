import { Component, OnInit } from '@angular/core';
import { AdministratorEntitiesService } from 'src/app/services/administrator-entities/administrator-entities.service';

@Component({
  selector: 'app-administrator-cottages-view',
  templateUrl: './administrator-cottages-view.component.html',
  styleUrls: ['./administrator-cottages-view.component.css']
})
export class AdministratorCottagesViewComponent implements OnInit {

  searchValue: string = "";
  cottages: any

  constructor(private entitesService: AdministratorEntitiesService) { }

  ngOnInit(): void {
    this.getCottages();
  }

  getCottages(){
    this.entitesService.getAllCottages().subscribe(cottages => this.cottages = cottages);
  }

  findCottage(){
   this.entitesService.getAllCottages().subscribe(
     cottages =>{
       this.cottages = cottages;
       let foundedCottages = [];

       for(let cottage of this.cottages)
        if(cottage.name.toLocaleLowerCase().includes(this.searchValue.toLocaleLowerCase()))
          foundedCottages.push(cottage);

        this.cottages = foundedCottages;
     }
   )
  }

  deleteCottage(cottageId: any){
    this.entitesService.deleteCottage(cottageId).subscribe(() => this.getCottages());
  }

}
