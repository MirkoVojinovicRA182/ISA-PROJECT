import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { AdventureAdditionalService } from 'src/app/model/adventure-additional-service';
import { InstructorLesson } from 'src/app/model/instructor-lesson';
import { InstructorLessonsService } from 'src/app/services/instructor-lessons/instructor-lessons.service';
import { InstructorAdditionalServiceDialogComponent } from '../instructor-additional-service-dialog/instructor-additional-service-dialog.component';
import { Image } from 'src/app/model/image';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-my-test',
  templateUrl: './my-test.component.html',
  styleUrls: ['./my-test.component.css']
})
export class MyTestComponent implements OnInit {

  lesson: InstructorLesson = new InstructorLesson();

  additionalServices: AdventureAdditionalService[] = [];

  images: Image[] = [];

  foundedAdditionalServices: AdventureAdditionalService[] = [];

  searchValue: string = "";

  newAdditionalService: AdventureAdditionalService = new AdventureAdditionalService();

  uploadImage: File | undefined;

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

        this.getAdditionalServices(id);

        this.getImages(id);
      }
    );
  }

  getAdditionalServices(id: number){
    this.instructorLessonService.getAdditionalServices(id).subscribe(
      services => this.additionalServices = services
    );
  }

  getImages(id: number){
    this.instructorLessonService.getImages(id).subscribe(
      images => this.images = images
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

  deleteImage(image: Image){
    const index = this.images.indexOf(image, 0);
    if (index > -1) {
      this.images.splice(index, 1);
    }
    

    this.instructorLessonService.deleteImage(image.id).subscribe();
  }

  onImageUpload(event: any){
    this.uploadImage = event.target.files[0];

    if(this.uploadImage != null){
      let image = new Image();
      image.url = this.uploadImage.name;
      image.adventureId = this.lesson.id;
      this.instructorLessonService.addImage(image).subscribe(() => this.images.push(image),
      () => alert('Image allready exists!'));
    }
  }

}
