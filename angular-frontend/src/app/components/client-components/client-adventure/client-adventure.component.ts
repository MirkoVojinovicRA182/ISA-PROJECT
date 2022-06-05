import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'src/app/model/subscription';
import { ClientService } from 'src/app/services/client/client.service';
import { InstructorHomePageService } from 'src/app/services/instructor-home-page/instructor-home-page.service';
import { InstructorLessonsService } from 'src/app/services/instructor-lessons/instructor-lessons.service';

@Component({
  selector: 'app-client-adventure',
  templateUrl: './client-adventure.component.html',
  styleUrls: ['./client-adventure.component.css']
})
export class ClientAdventureComponent implements OnInit {

  adventure: any;
  instructor: any;
  currentUser: any;
  additionalServices: any;

  checkedAdventure: boolean = true;
  checkedInstructor: boolean = true;
  
  constructor(private router: Router,  
    private instructorLessonsService: InstructorLessonsService,
    private clientService: ClientService,
    private instructorHomePageService: InstructorHomePageService) {}

  ngOnInit(): void {
    window.scroll(0,0)
    var selectedAdventure = localStorage.getItem('selectedAdventure')
    let currentUser = localStorage.getItem('currentUser')
    if(currentUser != null){
      this.currentUser = JSON.parse(currentUser)
    }
    if(selectedAdventure != null){
      this.adventure = JSON.parse(selectedAdventure)
      this.instructorLessonsService.getAdditionalServices(this.adventure.id).subscribe(data =>{
        this.additionalServices = data;
      })
      this.instructorHomePageService.getProfileInfo(this.adventure.instructorId).subscribe(data => {
        this.instructor = data
      })
    }
    let subcription: Subscription = {
      id: -1,
      clientId: this.currentUser.id,
      subscribedTo: this.adventure.instructorId
    };
    this.clientService.isSubscribedToUser(subcription).subscribe(data => {
      if(data == true){
        this.checkedInstructor = false
      }
    })
    let subcription2: Subscription = {
      id: -1,
      clientId: this.currentUser.id,
      subscribedTo: this.adventure.id
    };
    this.clientService.isSubscribedToAdventure(subcription2).subscribe(data => {
      if(data == true){
        this.checkedAdventure = false
      }
    })

  }

  subscribeUser(){
    let subcription: Subscription = new Subscription();
      subcription.clientId = this.currentUser.id;
      subcription.subscribedTo = this.instructor.id;
    if (!this.checkedInstructor){
      this.clientService.userSubscribe(subcription).subscribe()
      return
    }
    this.clientService.userUnSubscribe(subcription).subscribe()
  }

  subscribeAdventure(){
    let subcription: Subscription = new Subscription();
      subcription.clientId = this.currentUser.id;
      subcription.subscribedTo = this.adventure.id;
    if (!this.checkedAdventure){
      this.clientService.adventureSubscribe(subcription).subscribe()
      return
    }
    this.clientService.adventureUnSubscribe(subcription).subscribe()
  }

}
