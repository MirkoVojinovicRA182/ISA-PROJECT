import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-ships-owner-home-page',
  templateUrl: './ships-owner-home-page.component.html',
  styleUrls: ['./ships-owner-home-page.component.css']
})
export class ShipsOwnerHomePageComponent implements OnInit {

  constructor(public router: Router,
    public route: ActivatedRoute) { }

  ngOnInit(): void {
  }

}
