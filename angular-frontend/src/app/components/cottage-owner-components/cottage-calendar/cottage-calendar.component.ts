import { formatDate } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { CalendarOptions } from '@fullcalendar/angular';
import { CottagesService } from 'src/app/services/cottages/cottages.service';

@Component({
  selector: 'app-cottage-calendar',
  templateUrl: './cottage-calendar.component.html',
  styleUrls: ['./cottage-calendar.component.css']
})
export class CottageCalendarComponent implements OnInit {

  events: any[] = [];
  scheduled: any[] = [];

  cottage:any

  calendarOptions: CalendarOptions = {
    
  };

  constructor(private cottageService: CottagesService) { }

  ngOnInit(): void {
    window.scroll(0,0)
    var selectedCottage = localStorage.getItem('selectedCottage')
    if(selectedCottage != null){
      this.cottage = JSON.parse(selectedCottage)
    }

    for(let i = 0; i < this.cottage.cottageAvailability.length; i++){
      let myEndDate = new Date(this.cottage.cottageAvailability[i].endDate);
      myEndDate.setDate(myEndDate.getDate() + 1);
      this.events.push({title: "Dostupno", start: formatDate( this.cottage.cottageAvailability[i]?.startDate, 'yyy-MM-dd', 'en-US'),
      end: formatDate( myEndDate, 'yyyy-MM-dd', 'en-US')})
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
    };
  }

  handleSelect(arg: any) {
    let myEndDate=new Date(arg.endStr);
    myEndDate.setDate(myEndDate.getDate() - 1);
    let newAvailability = [{
      availabilityId: 0,
      startDate: arg.startStr,
      endDate: formatDate(myEndDate, 'yyyy-MM-dd', 'en-US'),
      cottageId: this.cottage.cottageId,
    }]
    this.cottageService.addAvailability(newAvailability).subscribe(
      data => {
        localStorage.setItem('selectedCottage', JSON.stringify(data)),
        window.location.reload()
      }
    )
  }

}
