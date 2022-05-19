import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-cottage-owner-home-page',
  templateUrl: './cottage-owner-home-page.component.html',
  styleUrls: ['./cottage-owner-home-page.component.css']
})
export class CottageOwnerHomePageComponent implements OnInit {

  constructor(public router: Router,
    public route: ActivatedRoute) { }

  ngOnInit(): void {
  }

}
