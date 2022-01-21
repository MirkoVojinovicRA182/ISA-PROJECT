import { Component, OnInit } from '@angular/core';
import { ReservationsService } from 'src/app/services/reservations/reservations.service';

@Component({
  selector: 'app-administrator-statistics',
  templateUrl: './administrator-statistics.component.html',
  styleUrls: ['./administrator-statistics.component.css']
})
export class AdministratorStatisticsComponent implements OnInit {

  buttonClass: string = "adminButton";
  role: string = "Administrator";

  systemSallary: number = 0;

  constructor(private reservationService: ReservationsService) { }

  ngOnInit(): void {
  }

  defineSystemSallary(){
    this.reservationService.defineSystemSallary(this.systemSallary).subscribe(
      () => alert('System sallary is updated.')
    );
  }

}
