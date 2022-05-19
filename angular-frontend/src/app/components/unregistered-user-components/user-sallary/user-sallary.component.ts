import { Component, Input, OnInit } from '@angular/core';
import { formatDate } from '@angular/common';
import { ReservationsService } from 'src/app/services/reservations/reservations.service';

@Component({
  selector: 'app-user-sallary',
  templateUrl: './user-sallary.component.html',
  styleUrls: ['./user-sallary.component.css']
})
export class UserSallaryComponent implements OnInit {

  @Input() generateButtonClass: string = "";
  @Input() role: string = "";

  messageDisplayed: boolean = false;
  todayDate:string = formatDate(new Date(), 'yyyy-MM-dd', 'en_US');


  fromDate: Date = new Date();
  toDate: Date = new Date();

  generatedSallaries: any;
  sum: number = 0;

  constructor(private reservationService: ReservationsService) { }

  ngOnInit(): void {
  }

  generateSallary(){
    if(this.role == "Instructor"){

      this.reservationService.getInstructorSallary(this.fromDate, this.toDate, 1).subscribe(generatedSallaries => 
        {
          this.countSallary(generatedSallaries);
        }
      );
    }

    else if(this.role == "Administrator"){
      this.reservationService.getSystemSallary(this.fromDate, this.toDate).subscribe(generatedSallaries => 
        {
          this.countSallary(generatedSallaries);
        }
      );
    }
  }

  countSallary(generatedSallaries: any){
    this.sum = 0;
    for(let s of generatedSallaries)
      this.sum += s.sallaryValue;

    this.generatedSallaries = generatedSallaries
    this.messageDisplayed = true;

    this.sum.toFixed(2);
  }


}
