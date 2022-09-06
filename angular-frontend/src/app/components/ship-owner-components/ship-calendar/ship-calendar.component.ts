import { formatDate } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { CalendarOptions } from '@fullcalendar/angular';
import { ReservationsService } from 'src/app/services/reservations/reservations.service';
import { ShipsService } from 'src/app/services/ships/ships.service';

@Component({
  selector: 'app-ship-calendar',
  templateUrl: './ship-calendar.component.html',
  styleUrls: ['./ship-calendar.component.css']
})
export class ShipCalendarComponent implements OnInit {

  events: any[] = [];
  scheduled: any[] = [];

  ship:any

  allUsersReservated: any;
  selectedUser: any;
  price: number = 0;
  action: boolean = false;
  duration: number = 0;
  actionPrice: number = 0;
  reportText: string = ""

  reservations: any;

  calendarOptions: CalendarOptions = {
  };

  constructor(private shipsService: ShipsService, private reservationService: ReservationsService) { }

  async ngOnInit(): Promise<void> {
    window.scroll(0,0)
    var selectedShip = localStorage.getItem('selectedShip')
    if(selectedShip != null){
      this.ship = JSON.parse(selectedShip)
    }

    this.shipsService.getAllUsersReservated(this.ship.shipOwnerId).subscribe(data => {
      this.allUsersReservated = data;
    })

    this.shipsService.getReservations(this.ship.shipId).subscribe(data => {
      this.reservations = data;
    })

    for(let i = 0; i < this.ship.shipAvailability.length; i++){
      let myEndDate = new Date(this.ship.shipAvailability[i].endDate);
      myEndDate.setDate(myEndDate.getDate() + 1);
      this.events.push({title: "Dostupno", start: formatDate( this.ship.shipAvailability[i]?.startDate, 'yyy-MM-dd HH:mm', 'en-US'),
      end: formatDate( myEndDate, 'yyyy-MM-dd HH:mm', 'en-US')})
    }

    await new Promise( resolve => setTimeout(resolve, 1000) );

    for(let i = 0; i < this.reservations.length; i++){
      //this.events.push({title: "Rezervisano", start: formatDate( data[i].startTime, 'yyy-MM-dd HH:mm', 'en-US'),
      //end: formatDate( data[i].endTime, 'yyyy-MM-dd HH:mm', 'en-US')})
      this.pushEvent(this.reservations[i].startTime, this.reservations[i].startTime, this.reservations[i].id)
    }

    this.calendarOptions = {
      headerToolbar: {
        left: 'prev,next today',
        center: 'title',
        right: ''
    },
      initialView: 'dayGridMonth',
      height: "auto",
      events: this.events,
      selectable:true,
      //editable:true,
      select: this.handleSelect.bind(this),
      eventClick: this.handleEventClick.bind(this),
    };
  }

  pushEvent(startTime: any, endTime:any, id: number){
    this.events.push({title: "Rezervisano"+id, start: formatDate( startTime, 'yyy-MM-dd HH:mm', 'en-US'),
        end: formatDate( endTime, 'yyyy-MM-dd HH:mm', 'en-US')})
  }

  handleSelect(arg: any) {
    if(!this.action){
      let myStartDate=new Date(arg.startStr);
      let myEndDate=new Date(arg.endStr);
      myEndDate.setDate(myEndDate.getDate() - 1);
      for(var event of this.events){
        if(new Date(event.start) <= new Date(myStartDate) && new Date(event.end) >= new Date(myEndDate)){
          let reservation = {
            price: this.price,
            clientId: this.selectedUser,
            shipId: this.ship.shipId,
            startTime: formatDate( myStartDate, 'yyyy-MM-dd HH:mm', 'en-US')
          }
          //this.cottageService.reservateCottage(reservation).subscribe()
          this.reservationService.bookShip(reservation).subscribe();
          window.location.reload()
          return;
        }
      }
      let newAvailability = [{
        availabilityId: 0,
        startDate: formatDate(myStartDate, 'yyyy-MM-dd HH:mm', 'en-US'),
        endDate: formatDate(myEndDate, 'yyyy-MM-dd HH:mm', 'en-US'),
        shipId: this.ship.shipId,
      }]
      this.shipsService.addAvailability(newAvailability).subscribe(
        data => {
          localStorage.setItem('selectedShip', JSON.stringify(data)),
          window.location.reload()
        }
      )
    }
    else{
      let myStartDate=new Date(arg.startStr);
      let myEndDate=new Date(arg.endStr);
      let action = {
        startTime: formatDate(myStartDate, 'yyyy-MM-dd HH:mm', 'en-US'),
        endTime: formatDate(myEndDate, 'yyyy-MM-dd HH:mm', 'en-US'),
        creationDate: formatDate(new Date(), 'yyyy-MM-dd HH:mm', 'en-US'),
        duration: this.duration,
        price: this.actionPrice,
        shipId: this.ship.shipId

      }
      this.shipsService.createAction(action).subscribe()
    }
  }

  handleEventClick(arg: any) {
    let myStartDate =  arg.event.start
    let text = arg.event.title
    if(text.includes("Rezervisano") && new Date(myStartDate) < new Date()){
      for(let res of this.reservations){
        if(res.id == text.replace("Rezervisano", "")){
          let report = {
            reportText: this.reportText,
            reservationId: res.id
          }
          this.shipsService.createReport(report).subscribe()
        }
      }
    }
    
  }

}
