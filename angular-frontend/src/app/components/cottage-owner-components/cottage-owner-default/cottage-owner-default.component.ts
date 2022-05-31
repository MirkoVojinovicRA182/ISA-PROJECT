import { Component, Inject, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import jwtDecode from 'jwt-decode';
import { UserProfileService } from 'src/app/services/user-profile/user-profile.service';
import { CottageOwnerDeleteAccountComponent } from '../cottage-owner-delete-account/cottage-owner-delete-account.component';

@Component({
  selector: 'app-cottage-owner-default',
  templateUrl: './cottage-owner-default.component.html',
  styleUrls: ['./cottage-owner-default.component.css']
})
export class CottageOwnerDefaultComponent implements OnInit {

  constructor(private userService: UserProfileService, public detailsDialog: MatDialog) { }

  cottageOwner:any
  editEnabled: boolean = true

  ngOnInit(): void {
    window.scroll(0,0)
    var token = localStorage.getItem('token');
    if(token != null){
      this.userService.getCottageOwner(jwtDecode<any>(JSON.parse(token).accessToken).sub).subscribe(
        cottageOwner => this.cottageOwner = cottageOwner
      )
    }
  }

  edit(event:any){
    this.editEnabled = !this.editEnabled
    if(event.textContent == "Edit"){
      event.textContent = "Save"
    }else{
      this.userService.updateCottageOwner(this.cottageOwner).subscribe()
      event.textContent = "Edit"
    }
  }

  showDeleteAccountDialog(){
    let deleteRequest = {
      reason: "",
      userId: this.cottageOwner.userId,
      userType: 0,
      userFullName: this.cottageOwner.name + " " + this.cottageOwner.lastName
    }
    const dialogRef = this.detailsDialog.open(CottageOwnerDeleteAccountComponent, {
      data: deleteRequest,
      panelClass: 'backdropBackground',
      disableClose: false
    });
    console.log(deleteRequest)
    dialogRef.afterClosed().subscribe(request => {
      deleteRequest = request
      console.log(request)
    }
    );
  }

}
