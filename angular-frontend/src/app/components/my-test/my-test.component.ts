import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { AdventureAdditionalService } from 'src/app/model/adventure-additional-service';
import { Instructor } from 'src/app/model/instructor';
import { InstructorLesson } from 'src/app/model/instructor-lesson';
import { InstructorLessonsService } from 'src/app/services/instructor-lessons/instructor-lessons.service';
import { InstructorAdditionalServiceDialogComponent } from '../instructor-additional-service-dialog/instructor-additional-service-dialog.component';

@Component({
  selector: 'app-my-test',
  templateUrl: './my-test.component.html',
  styleUrls: ['./my-test.component.css']
})
export class MyTestComponent implements OnInit {

  lesson: InstructorLesson = new InstructorLesson();
  additionalServices: AdventureAdditionalService[] = [];
  foundedAdditionalServices: AdventureAdditionalService[] = [];
  searchValue: string = "";
  newAdditionalService: AdventureAdditionalService = new AdventureAdditionalService();

  constructor(private route: ActivatedRoute,
              private router: Router,
              private instructorLessonService: InstructorLessonsService,
              private detailsDialog: MatDialog) { }

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    if(id)
      this.getLesson(id);
  }

  getLesson(id: number){
    this.instructorLessonService.getLessonById(id).subscribe(
      lesson => 
      {
        this.lesson = lesson;
        this.instructorLessonService.getAdditionalServices(id).subscribe(
          services => this.additionalServices = services
        );
      }
    );
  }

  modifyLesson(){
    this.instructorLessonService.modifyLesson(this.lesson).subscribe(() => this.getLesson(this.lesson.id));
  }

  addAdditionalService(){
    const dialogRef = this.detailsDialog.open(InstructorAdditionalServiceDialogComponent, {
      data: new AdventureAdditionalService(),
      disableClose: true
    });

    dialogRef.afterClosed().subscribe(newAdditionalService => {
      newAdditionalService.adventureId = this.lesson.id;
      this.instructorLessonService.addAdditionalService(newAdditionalService).subscribe(() => this.getLesson(this.lesson.id));
    });
  }

  deleteAdditionalService(additionalServiceId: number){
    this.instructorLessonService.deleteAdditionalService(additionalServiceId).subscribe(() => this.getLesson(this.lesson.id));
  }

  findServices(){
    this.instructorLessonService.getAdditionalServices(this.lesson.id).subscribe(
      services =>
      {
         this.additionalServices = services
         this.foundedAdditionalServices = [];

         for(let service of this.additionalServices)
          if(service.name.toLocaleLowerCase().includes(this.searchValue.toLocaleLowerCase()))
            this.foundedAdditionalServices.push(service);

         this.additionalServices = this.foundedAdditionalServices;
      }
    );
  }

}
