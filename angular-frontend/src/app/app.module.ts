import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { InstructorHomePageComponent } from './components/instructor-home-page/instructor-home-page/instructor-home-page.component';
import { InstructorProfileInfoComponent } from './components/instructor-profile/instructor-profile-info/instructor-profile-info.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { InstructorSettingsComponent } from './components/instructor-settings/instructor-settings/instructor-settings.component';
import { InstructorCalendarComponent } from './components/instructor-calendar/instructor-calendar.component';
import { InstructorLessonsComponent } from './components/instructor-lessons/instructor-lessons.component';
import { InstructorOneLessonComponent } from './components/instructor-one-lesson/instructor-one-lesson.component';
import { InstructorOneLessonDetailsComponent } from './components/instructor-one-lesson-details/instructor-one-lesson-details.component';


import {MatDialogModule} from '@angular/material/dialog';
import {MatTableModule} from '@angular/material/table';
import {MatButtonModule} from '@angular/material/button';
import { InstructorAddLessonComponent } from './components/instructor-add-lesson/instructor-add-lesson.component';

@NgModule({
  declarations: [
    AppComponent,
    InstructorHomePageComponent,
    InstructorProfileInfoComponent,
    InstructorSettingsComponent,
    InstructorCalendarComponent,
    InstructorLessonsComponent,
    InstructorOneLessonComponent,
    InstructorOneLessonDetailsComponent,
    InstructorAddLessonComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,

    MatDialogModule,
    MatTableModule,
    MatButtonModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
