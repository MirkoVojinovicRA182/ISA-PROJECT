import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import jwtDecode from 'jwt-decode';
import { UserProfileService } from 'src/app/services/user-profile/user-profile.service';
import { CottageOwnerDeleteAccountComponent } from '../../cottage-owner-components/cottage-owner-delete-account/cottage-owner-delete-account.component';

@Component({
  selector: 'app-ships-owner-default',
  templateUrl: './ships-owner-default.component.html',
  styleUrls: ['./ships-owner-default.component.css']
})
export class ShipsOwnerDefaultComponent implements OnInit {

  shipOwner:any
  editDisabled: boolean = true
  passwordChangeEnabled: boolean = false
  newPassword: string = ""
  newPasswordConfirm: string = ""

  constructor(public detailsDialog: MatDialog, private userService: UserProfileService) { }

  ngOnInit(): void {
    window.scroll(0,0)
    var currentUser: any = localStorage.getItem('currentUser')
    if(currentUser != null){
      currentUser = JSON.parse(currentUser)
      this.userService.getShipOwner(currentUser.id).subscribe(
        shipOwner => this.shipOwner = shipOwner
      )
    }
  }

  edit(event:any){
    this.editDisabled = !this.editDisabled
    if(event.textContent == "Edit"){
      event.textContent = "Save"
    }else{
      //this.userService.updateCottageOwner(this.cottageOwner).subscribe()
      event.textContent = "Edit"
    }
  }

  changePassword(event:any){
    this.passwordChangeEnabled = !this.passwordChangeEnabled
    if(event.textContent == "Change password"){
      event.textContent = "Save changes"
    }else{
      let data = {
        //userId: this.cottageOwner.userId,
        userType: 0,
        newPassword: this.newPassword
      }
      /*this.userService.updatePassword(data).subscribe(
        user => {this.cottageOwner
        console.log(user)}
      )*/
      event.textContent = "Change password"
    }
  }

  showDeleteAccountDialog(){
    let deleteRequest = {
      deleteReason: "",
      userId: this.shipOwner.userId,
      userType: 0,
      userFullName: this.shipOwner.name + " " + this.shipOwner.lastName
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
