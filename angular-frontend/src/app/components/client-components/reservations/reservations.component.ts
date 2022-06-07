import { Component, OnInit } from '@angular/core';
import * as moment from 'moment';
import { SelectItem, FilterService, FilterMatchMode, MessageService } from 'primeng/api';
import { DialogService, DynamicDialogConfig, DynamicDialogRef } from 'primeng/dynamicdialog';
import { AdventureAdditionalService } from 'src/app/model/adventure-additional-service';
import { CottagesService } from 'src/app/services/cottages/cottages.service';
import { InstructorHomePageService } from 'src/app/services/instructor-home-page/instructor-home-page.service';
import { InstructorLessonsService } from 'src/app/services/instructor-lessons/instructor-lessons.service';
import { ReservationsService } from 'src/app/services/reservations/reservations.service';
import { ShipsService } from 'src/app/services/ships/ships.service';

@Component({
  selector: 'app-reservations',
  templateUrl: './reservations.component.html',
  styleUrls: ['./reservations.component.css'],
  providers: [DialogService]
})
export class ReservationsComponent implements OnInit {

  cottages: any;
  ships: any;
  adventures: any;
  currentUser: any;

  displayCottage: boolean = false;
  displayShip: boolean = false;
  displayAdventure: boolean = false;

  colsCottage: any[] = [];
  colsShip: any[] = [];
  colsAdventure: any[] = [];

  minDate: Date = new Date();
  dateCottage: Date = new Date();
  dateShip: Date = new Date();
  dateAdventure: Date = new Date();

  matchModeOptions: SelectItem[] = [];

  penal: boolean = true;

  services: any;

  constructor(private filterService: FilterService,
    private cottageService: CottagesService,
    private reservationService: ReservationsService,
    public dialogService: DialogService,
    private shipService: ShipsService,
    private adventureService: InstructorLessonsService,
    private instructorService: InstructorHomePageService) {
  }

  ngOnInit() {
    const customFilterName = 'custom-equals';
    this.dateCottage.setDate(this.dateCottage.getDate() + 1);
    this.dateShip.setDate(this.dateShip.getDate() + 1);
    this.dateAdventure.setDate(this.dateAdventure.getDate() + 1);
    this.minDate = this.dateCottage;
    let user = localStorage.getItem('currentUser')
        if (user != null) {
          this.currentUser = JSON.parse(user)
        }
    if(this.currentUser.penals > 2){
      this.penal =  false
    }
    
    this.filterService.register(customFilterName, (value: { toString: () => any; } | null | undefined, filter: string | null | undefined): boolean => {
      if (filter === undefined || filter === null || filter.trim() === '') {
        return true;
      }

      if (value === undefined || value === null) {
        return false;
      }

      return value.toString() === filter.toString();
    });

    this.colsCottage = [
      { field: 'name', header: 'Name' },
      { field: 'address', header: 'Address' },
      { field: 'pricelist', header: 'Price' },
      { field: 'rating', header: 'Rating' },
    ];
    this.colsShip = [
      { field: 'name', header: 'Name' },
      { field: 'address', header: 'Address' },
      { field: 'pricelist', header: 'Price' },
      { field: 'rating', header: 'Rating' },
    ];
    this.colsAdventure = [
      { field: 'name', header: 'Name' },
      { field: 'address', header: 'Address' },
      { field: 'price', header: 'Price' },
      { field: 'rating', header: 'Rating' },
    ];

    this.matchModeOptions = [
      { label: 'Contains', value: FilterMatchMode.CONTAINS },
      { label: 'Custom Equals', value: customFilterName },
      { label: 'Starts With', value: FilterMatchMode.STARTS_WITH },
    ];
    this.cottageService.getAllCottages().subscribe(
      cottages => {
        this.cottages = cottages
      }
    );
    this.shipService.getAllShips().subscribe(
      ships => {
        this.ships = ships
      }
    );
    this.adventureService.getAllLessons().subscribe({
      next: adventures => {
        this.adventures = adventures
        //this.getInfoAboutAdventures(adventures)
      }
    })

  }

  /*getInfoAboutAdventures(adventures: any) {
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
  }*/

  showCottage(cottage: any) {
    let params = {
      id: cottage.cottageId,
      startTime: moment(this.dateCottage).format('YYYY-MM-DD HH:mm'),
      endTime: moment(this.dateCottage).format('YYYY-MM-DD HH:mm')
    }
    this.reservationService.isCottageFree(params).subscribe((data: boolean) => {
      if (data == true) {
        this.showCottageIfTrue(cottage, params)
      } else {
        this.displayCottage = true;
      }
    })
  }
  showCottageIfTrue(cottage: any, params: any) {
    const ref = this.dialogService.open(DialogCottageReservation, {
      data: {
        cottage: cottage,
      },
      width: 'auto',
      height: 'auto'
    });

    ref.onClose.subscribe((data) => {
      if (data.yes) {
        let param = {
          id: 0,
          clientId: this.currentUser.id,
          cottageId: params.id,
          startTime: params.startTime,
          endTime: params.endTime,
          price: cottage.pricelist
        }
        this.reservationService.bookCottage(param).subscribe(data => { console.log(data) })
      }
    });
  }

  showShip(ship: any) {
    let params = {
      id: ship.shipId,
      startTime: moment(this.dateShip).format('YYYY-MM-DD HH:mm'),
      endTime: moment(this.dateShip).format('YYYY-MM-DD HH:mm')
    }
    this.reservationService.isShipFree(params).subscribe((data: boolean) => {
      if (data == true) {
        this.showShipIfTrue(ship, params)
      } else {
        this.displayShip = true;
      }
    })
  }
  showShipIfTrue(ship: any, params: any) {
    const ref = this.dialogService.open(DialogShipReservation, {
      data: {
        ship: ship,
      },
      width: 'auto',
      height: 'auto'
    });

    ref.onClose.subscribe((data) => {
      if (data.yes) {
        let user = localStorage.getItem('currentUser')
        if (user != null) {
          this.currentUser = JSON.parse(user)
        }
        let param = {
          id: 0,
          clientId: this.currentUser.id,
          shipId: params.id,
          startTime: params.startTime,
          price: ship.pricelist
        }
        this.reservationService.bookShip(param).subscribe(data => { console.log(data) })
      }
    });
  }

  showAdventure(adventure: any) {
    let params = {
      id: adventure.id,
      startTime: moment(this.dateAdventure).format('YYYY-MM-DD HH:mm'),
      endTime: moment(this.dateAdventure).format('YYYY-MM-DD HH:mm')
    }
    this.reservationService.isAdventureFree(params).subscribe((data: boolean) => {
      if (data == true) {
        this.showAdventureIfTrue(adventure, params)
      } else {
        this.displayAdventure = true;
      }
    })
  }
  showAdventureIfTrue(adventure: any, params: any) {
    const ref = this.dialogService.open(DialogAdventureReservation, {
      data: {
        adventure: adventure,
        services: this.services
      },
      width: 'auto',
      height: 'auto'
    });

    ref.onClose.subscribe((data) => {
      if (data.yes) {
        let user = localStorage.getItem('currentUser')
        if (user != null) {
          this.currentUser = JSON.parse(user)
        }
        let param = {
          id: 0,
          clientId: this.currentUser.id,
          adventureId: params.id,
          startTime: params.startTime,
          endTime: params.endTime,
          price: adventure.price
        }
        this.reservationService.bookAdventure(param).subscribe(data => { console.log(data) })
      }
    });
  }
}

@Component({
  templateUrl: './dialogs/dialogCottageReservation.html'
})
export class DialogCottageReservation {

  reservation: any;
  price: number = 0;

  constructor(public ref: DynamicDialogRef, public config: DynamicDialogConfig) { }

  ngOnInit() {
    this.reservation = this.config.data.cottage
  }

  close() {
    this.ref.close({ yes: false, price: this.price });
  }

  save() {
    this.ref.close({ yes: true, price: this.price });
  }
}

@Component({
  templateUrl: './dialogs/dialogShipReservation.html'
})
export class DialogShipReservation {

  reservation: any;
  price: number = 0;

  constructor(public ref: DynamicDialogRef, public config: DynamicDialogConfig) { }

  ngOnInit() {
    this.reservation = this.config.data.ship
  }

  close() {
    this.ref.close({ yes: false, price: this.price });
  }

  save() {
    this.ref.close({ yes: true, price: this.price });
  }
}

@Component({
  templateUrl: './dialogs/dialogAdventureReservation.html'
})
export class DialogAdventureReservation {

  reservation: any;
  services: any;
  selectedServices: any = [];
  price: number = 0;
  firstPrice: number = 0;

  constructor(public ref: DynamicDialogRef, public config: DynamicDialogConfig,
    private instructorService: InstructorLessonsService) { }

  ngOnInit() {
    this.reservation = this.config.data.adventure
    this.price = this.reservation.price
    this.firstPrice = this.reservation.price
    this.instructorService.getAdditionalServices(this.reservation.id).subscribe(data => {
      this.services = data
    })
  }

  close() {
    this.ref.close({ yes: false, price: this.price });
  }

  save() {
    this.ref.close({ yes: true, price: this.price });
  }

  addToPrice(service: any) {
    this.price = this.firstPrice
    this.selectedServices.forEach((element: any) => {
      this.price = this.price + element.price 
    });
    this.reservation.price = this.price
  }
}
