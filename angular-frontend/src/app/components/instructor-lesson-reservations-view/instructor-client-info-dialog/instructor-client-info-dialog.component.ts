import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { User } from 'src/app/model/user';
import { UserProfileService } from 'src/app/services/user-profile/user-profile.service';

@Component({
  selector: 'app-instructor-client-info-dialog',
  templateUrl: './instructor-client-info-dialog.component.html',
  styleUrls: ['./instructor-client-info-dialog.component.css']
})
export class InstructorClientInfoDialogComponent{

  constructor(public dialogRef: MatDialogRef<InstructorClientInfoDialogComponent>,
              @Inject(MAT_DIALOG_DATA)
              public client: User,
              private userService: UserProfileService) { }


}
