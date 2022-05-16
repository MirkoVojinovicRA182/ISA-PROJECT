import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

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
  ]
  
  constructor(private router: Router) { 
    this.cottage = this.router?.getCurrentNavigation()?.extras.state;
  }

  ngOnInit(): void {
  }

}
