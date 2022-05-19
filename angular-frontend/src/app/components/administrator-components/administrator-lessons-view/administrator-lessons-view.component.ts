import { Component, OnInit } from '@angular/core';
import { InstructorLesson } from 'src/app/model/instructor-lesson';
import { InstructorLessonsService } from 'src/app/services/instructor-lessons/instructor-lessons.service';

@Component({
  selector: 'app-administrator-lessons-view',
  templateUrl: './administrator-lessons-view.component.html',
  styleUrls: ['./administrator-lessons-view.component.css']
})
export class AdministratorLessonsViewComponent implements OnInit {

  lessons: InstructorLesson[] = [];
  searchValue: string = "";

  constructor(private instructorLessonsService: InstructorLessonsService) { }

  ngOnInit(): void {
    this.getAllLessons();
  }

  getAllLessons(){
    this.instructorLessonsService.getAllLessons().subscribe(data => this.lessons = data);
  }

  deleteLesson(lesson: InstructorLesson){
    this.instructorLessonsService.deleteLesson(lesson.id).subscribe(() => this.getAllLessons());
  }

  findLesson(){

    this.instructorLessonsService.getAllLessons().subscribe(
      lessons =>
      {
        this.lessons = lessons;
        let foundedLessons = [];

        for(let lesson of this.lessons)
        if(lesson.name.toLocaleLowerCase().includes(this.searchValue.toLocaleLowerCase()))
          foundedLessons.push(lesson);
        
        this.lessons = foundedLessons;
      }
    )
  }

}
