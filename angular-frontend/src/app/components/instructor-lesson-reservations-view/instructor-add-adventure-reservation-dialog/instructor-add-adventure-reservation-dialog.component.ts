import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { AdventureAdditionalService } from 'src/app/model/adventure-additional-service';
import { AdventureReservation } from 'src/app/model/adventure-reservation';
import { InstructorLesson } from 'src/app/model/instructor-lesson';
import { InstructorLessonsService } from 'src/app/services/instructor-lessons/instructor-lessons.service';

@Component({
  selector: 'app-instructor-add-adventure-reservation-dialog',
  templateUrl: './instructor-add-adventure-reservation-dialog.component.html',
  styleUrls: ['./instructor-add-adventure-reservation-dialog.component.css']
})
export class InstructorAddAdventureReservationDialogComponent implements OnInit{

  adventures: InstructorLesson[] = [];
  additionalServices: AdventureAdditionalService[] = [];
  selectedAdventure: InstructorLesson = new InstructorLesson();
  newReservation: AdventureReservation = new AdventureReservation();
  
  start: Date = new Date();

  constructor(public dialogRef: MatDialogRef<InstructorAddAdventureReservationDialogComponent>,
              private lessonService: InstructorLessonsService) {
              }

  ngOnInit(): void {
    this.lessonService.getAllLessons().subscribe(adventures =>
      { 
        this.adventures = adventures;
      }
    );
  }

  showAdditionalServices(){
    this.newReservation.adventureName = this.selectedAdventure.name;
    this.lessonService.getAdditionalServices(this.selectedAdventure.id).subscribe(services => this.additionalServices = services);
  }

  setStart(val: any){
    this.newReservation.startTime = val;
    this.newReservation.endTime = val;
  }

  countBill(val: number, e: any){
    if(e.target.checked)
      this.newReservation.bill += val;
    else
    this.newReservation.bill -= val;
  }
}
