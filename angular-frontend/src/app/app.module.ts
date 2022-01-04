import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { InstructorHomePageComponent } from './components/instructor-home-page/instructor-home-page/instructor-home-page.component';
import { InstructorProfileInfoComponent } from './components/instructor-profile/instructor-profile-info/instructor-profile-info.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { InstructorCalendarComponent } from './components/instructor-calendar/instructor-calendar.component';
import { InstructorLessonsComponent } from './components/instructor-lessons/instructor-lessons.component';
import { InstructorOneLessonComponent } from './components/instructor-one-lesson/instructor-one-lesson.component';
import { InstructorOneLessonDetailsComponent } from './components/instructor-one-lesson-details/instructor-one-lesson-details.component';


import {MatDialogModule} from '@angular/material/dialog';
import {MatTableModule} from '@angular/material/table';
import {MatButtonModule} from '@angular/material/button';
import { InstructorAddLessonComponent } from './components/instructor-add-lesson/instructor-add-lesson.component';
import { AdministratorHomePageComponent } from './components/administrator-home-page/administrator-home-page.component';
import { AdministratorRegistrationRequestsComponent } from './components/administrator-registration-requests/administrator-registration-requests.component';
import { AdministratorRegisterAdministratorComponent } from './components/administrator-register-administrator/administrator-register-administrator.component';
import { AdministratorUsersViewComponent } from './components/administrator-users-view/administrator-users-view.component';
import { UserProfileComponent } from './components/user-profile/user-profile.component';
import { MyTestComponent } from './components/my-test/my-test.component';
import { InstructorAdditionalServiceDialogComponent } from './components/instructor-additional-service-dialog/instructor-additional-service-dialog.component';
import { UserSettingsComponent } from './components/user-settings/user-settings.component';
import { ChangePasswordDialogComponent } from './components/user-settings/change-password-dialog/change-password-dialog.component';
import { DeleteAccountDialogComponent } from './components/user-settings/delete-account-dialog/delete-account-dialog.component';

@NgModule({
  declarations: [
    AppComponent,
    InstructorHomePageComponent,
    InstructorProfileInfoComponent,
    InstructorCalendarComponent,
    InstructorLessonsComponent,
    InstructorOneLessonComponent,
    InstructorOneLessonDetailsComponent,
    InstructorAddLessonComponent,
    AdministratorHomePageComponent,
    AdministratorRegistrationRequestsComponent,
    AdministratorRegisterAdministratorComponent,
    AdministratorUsersViewComponent,
    UserProfileComponent,
    MyTestComponent,
    InstructorAdditionalServiceDialogComponent,
    UserSettingsComponent,
    ChangePasswordDialogComponent,
    DeleteAccountDialogComponent,
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
