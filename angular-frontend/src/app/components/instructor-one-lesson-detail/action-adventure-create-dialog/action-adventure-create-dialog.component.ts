import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ActionAdventure } from 'src/app/model/action-adventure';
import { AdventureAdditionalService } from 'src/app/model/adventure-additional-service';
import { InstructorLessonsService } from 'src/app/services/instructor-lessons/instructor-lessons.service';
import { setMinDate } from 'src/app/utility';

@Component({
  selector: 'app-action-adventure-create-dialog',
  templateUrl: './action-adventure-create-dialog.component.html',
  styleUrls: ['./action-adventure-create-dialog.component.css']
})
export class ActionAdventureCreateDialogComponent implements OnInit {

  additionalServices: AdventureAdditionalService[] = [];

  newAction: ActionAdventure = new ActionAdventure();

  tempServ: String[] = [];

  currentDate: string = setMinDate();

  constructor(public dialogRef: MatDialogRef<ActionAdventureCreateDialogComponent>,
              private lessonService: InstructorLessonsService,
              @Inject(MAT_DIALOG_DATA) public lessonId: number) { }

  ngOnInit(): void {
    this.lessonService.getAdditionalServices(this.lessonId).subscribe(services => this.additionalServices = services);
  }

  
  setStart(val: any){
    this.newAction.startTime = val;
  }

  setEnd(val: any){
    this.newAction.endTime = val;
  }

  checkService(val: string, e: any){

    if(e.target.checked)
      this.tempServ.push(val);

    else{
      const index = this.tempServ.indexOf(val, 0);

      if (index > -1)
        this.tempServ.splice(index, 1);
    }

    this.newAction.additionalServices = "";
    for(let val of this.tempServ)
      this.newAction.additionalServices = this.newAction.additionalServices.concat(val + ' ');
  }

}
