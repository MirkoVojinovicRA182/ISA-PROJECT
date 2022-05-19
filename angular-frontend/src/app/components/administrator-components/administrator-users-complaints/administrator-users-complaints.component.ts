import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ComplaintAnswer } from 'src/app/model/complaint-answer';
import { InstructorComplaint } from 'src/app/model/instructor-complaint';
import { OwnerComplaint } from 'src/app/model/owner-complaint';
import { ComplaintsService } from 'src/app/services/complaints/complaints.service';
import { WriteAnswerDialogComponent } from './write-answer-dialog/write-answer-dialog.component';

@Component({
  selector: 'app-administrator-users-complaints',
  templateUrl: './administrator-users-complaints.component.html',
  styleUrls: ['./administrator-users-complaints.component.css']
})
export class AdministratorUsersComplaintsComponent implements OnInit {

  instructorComplaints: InstructorComplaint[] = [];
  shipComplaints: OwnerComplaint[] = [];
  cottageComplaints: OwnerComplaint[] = [];

  searchValueInstructorC: string = "";
  searchValueShipC: string = "";
  searchValueCottageC: string = "";

  iTableDisplayed: boolean = false;
  sTableDisplayed: boolean = false;
  cTableDisplayed: boolean = false;

  constructor(private detailsDialog: MatDialog,
              private complaintService: ComplaintsService) { }

  ngOnInit(): void {
    this.complaintService.getInstructorComplaints().subscribe(instructorComplaints => this.instructorComplaints = instructorComplaints);

    this.complaintService.getShipsComplaints().subscribe(shipComplaints => this.shipComplaints = shipComplaints);

    this.complaintService.getCottagesComplaints().subscribe(cottageComplaints => this.cottageComplaints = cottageComplaints);
  }


  openComplaintAnswerDialog(complaint: any){
    const dialogRef = this.detailsDialog.open(WriteAnswerDialogComponent, {});

    dialogRef.afterClosed().subscribe(answerText =>
      {
        let answer = new ComplaintAnswer();

        answer.answerText = answerText;
        answer.clientEmail = complaint.clientEmail;
        answer.serviceProviderEmail = complaint.instructorEmail;

        this.sendComplaintAnswer(answer);
      })
  }

  sendComplaintAnswer(answer: ComplaintAnswer){
    this.complaintService.sendComplaintAnswer(answer).subscribe();
  }


  findInstructorComplaint(){
   this.complaintService.getInstructorComplaints().subscribe(instructorComplaints =>
    {
      this.instructorComplaints = instructorComplaints;
      let foundedComplaints = [];

      for(let c of this.instructorComplaints)
      if(c.instructorName.toLocaleLowerCase().includes(this.searchValueInstructorC.toLocaleLowerCase()))
       foundedComplaints.push(c);

      this.instructorComplaints = foundedComplaints;
   })
  }

  findShipComplaint(){
    this.complaintService.getShipsComplaints().subscribe(shipComplaints =>
      {
        this.shipComplaints = shipComplaints;
        let foundedComplaints = [];
  
        for(let s of this.shipComplaints)
        if(s.ownerEntityName.toLocaleLowerCase().includes(this.searchValueShipC.toLocaleLowerCase()))
         foundedComplaints.push(s);
  
        this.shipComplaints = foundedComplaints;
     })
  }

  findCottageComplaint(){
    this.complaintService.getCottagesComplaints().subscribe(cottageComplaints =>
      {
        this.cottageComplaints = cottageComplaints;
        let foundedComplaints = [];
  
        for(let c of this.cottageComplaints)
        if(c.ownerEntityName.toLocaleLowerCase().includes(this.searchValueShipC.toLocaleLowerCase()))
         foundedComplaints.push(c);
  
        this.cottageComplaints = foundedComplaints;
     })
  }

  showTable(num: number){
    if(num == 1){
      this.iTableDisplayed = true;
      this.sTableDisplayed = false;
      this.cTableDisplayed = false;
    }

    else if(num == 2){
      this.iTableDisplayed = false;
      this.sTableDisplayed = true;
      this.cTableDisplayed = false;
    }

    else{
      this.iTableDisplayed = false;
      this.sTableDisplayed = false;
      this.cTableDisplayed = true;
    }
  }

}
