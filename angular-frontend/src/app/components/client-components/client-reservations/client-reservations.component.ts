import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { SortEvent } from 'primeng/api/sortevent';
import { CottagesService } from 'src/app/services/cottages/cottages.service';
import { InstructorHomePageService } from 'src/app/services/instructor-home-page/instructor-home-page.service';
import { InstructorLessonsService } from 'src/app/services/instructor-lessons/instructor-lessons.service';
import { ShipsService } from 'src/app/services/ships/ships.service';

@Component({
  selector: 'app-client-reservations',
  templateUrl: './client-reservations.component.html',
  styleUrls: ['./client-reservations.component.css']
})
export class ClientReservationsComponent implements OnInit {

  cottages: any;
  ships: any;
  adventures: any;
  reshapedAdventures: any = [];

  constructor(private cottageService: CottagesService,
    private shipService: ShipsService,
    private adventureService: InstructorLessonsService,
    private instructorService: InstructorHomePageService,
    private router: Router,
    private activeRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.getAllCottages();
    this.getAllShips();
    this.getAllAdventures();
  }

  getAllCottages(){
    this.cottageService.getAllCottages().subscribe(
      cottages => {
        this.cottages = cottages
      }
    );
  }

  getAllShips(){
    this.shipService.getAllShips().subscribe(
      ships => {
        this.ships = ships
      }
    );
  }

  getAllAdventures() {
    this.adventureService.getAllLessons().subscribe({
      next: adventures => {
        this.adventures = adventures
        this.getInfoAboutAdventures(adventures)
      }
    });
  }

  getInfoAboutAdventures(adventures: any) {
    adventures.forEach((element: any) => {
      this.instructorService.getProfileInfo(element.instructorId).subscribe({
        next: response => {
          this.reshapedAdventures.push({
            adventure: element,
            instructor: response
          });
        }
      })
    });
  }

  goToCottageDetails(cottage: any){
    var selectedCottage = JSON.stringify(cottage)
    localStorage.setItem('selectedCottage', selectedCottage)
    this.router.navigate(['client/cottageDetails'], )
  }

  goToShipDetails(ship: any){
    var selectedShip = JSON.stringify(ship)
    localStorage.setItem('selectedShip', selectedShip)
    this.router.navigate(['client/shipDetails'], )
  }

  goToAdventureDetails(adventure: any){
    var selectedAdventure = JSON.stringify(adventure)
    localStorage.setItem('selectedAdventure', selectedAdventure)
    this.router.navigate(['client/adventureDetails'], )
  }
}


