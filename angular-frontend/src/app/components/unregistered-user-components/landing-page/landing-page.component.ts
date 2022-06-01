import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-landing-page',
  templateUrl: './landing-page.component.html',
  styleUrls: ['./landing-page.component.css']
})
export class LandingPageComponent implements OnInit {

  constructor(private router: Router, private activeRoute: ActivatedRoute) { }

  ngOnInit(): void {
  }

  routeToRegistration(){
    this.router.navigate(['/registration']);
  }

  routeToInstructor(){
    this.router.navigate(['/instructor']);
  }

  routeToAdmin(){
    this.router.navigate(['/admin']);
  }

  redirectToLogin(){
    this.router.navigate(['login'], {relativeTo: this.activeRoute})
  }

  redirectToRegistration(){
    this.router.navigate(['registration'], {relativeTo: this.activeRoute})
  }

  redirectToCottages(){
    this.router.navigate(['allCottages'], {relativeTo: this.activeRoute})
  }

  redirectToAdventures(){
    this.router.navigate(['allAdventures'], {relativeTo: this.activeRoute})
  }

  redirectToShips(){
    this.router.navigate(['allShips'], {relativeTo: this.activeRoute})
  }

}
