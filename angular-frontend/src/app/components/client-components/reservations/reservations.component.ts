import { Component, OnInit } from '@angular/core';
import * as moment from 'moment';
import { SelectItem, FilterService, FilterMatchMode, MessageService } from 'primeng/api';
import { DialogService, DynamicDialogConfig, DynamicDialogRef } from 'primeng/dynamicdialog';
import { CottagesService } from 'src/app/services/cottages/cottages.service';
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
  currentUser: any;

  displayCottage: boolean = false;
  displayShip: boolean = false;

  colsCottage: any[] = [];
  colsShip: any[] = [];

  minDate: Date = new Date();
  dateCottage: Date = new Date();
  dateShip: Date = new Date();

  matchModeOptions: SelectItem[] = [];

  constructor(private filterService: FilterService,
    private cottageService: CottagesService,
    private reservationService: ReservationsService,
    public dialogService: DialogService,
    private shipService: ShipsService) {
  }

  ngOnInit() {
    const customFilterName = 'custom-equals';
    this.dateCottage.setDate(this.dateCottage.getDate() + 1);
    this.dateShip.setDate(this.dateShip.getDate() + 1);
    this.minDate = this.dateCottage;
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
  }

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
        let user = localStorage.getItem('currentUser')
        if (user != null) {
          this.currentUser = JSON.parse(user)
        }
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
