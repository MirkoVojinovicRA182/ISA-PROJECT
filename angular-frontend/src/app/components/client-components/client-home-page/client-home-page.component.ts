import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'client',
  templateUrl: './client-home-page.component.html',
  styleUrls: ['./client-home-page.component.css']
})
export class ClientHomePageComponent implements OnInit {

  constructor(private router: Router, private activeRoute: ActivatedRoute) { }

  ngOnInit(): void {
  }

  navigateToHomePage() {
    this.router.navigate(['client/reservations']);
  }

  navigateToProfilePage() {
    this.router.navigate(['profile'], {relativeTo: this.activeRoute});
  }

}
