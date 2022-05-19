import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-administrator-home-page',
  templateUrl: './administrator-home-page.component.html',
  styleUrls: ['./administrator-home-page.component.css']
})
export class AdministratorHomePageComponent implements OnInit {

  constructor(public router: Router,
    public route: ActivatedRoute) { }

  ngOnInit(): void {
  }

}
