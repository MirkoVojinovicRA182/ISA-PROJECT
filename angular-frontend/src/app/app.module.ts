import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { InstructorHomePageComponent } from './components/instructor-home-page/instructor-home-page/instructor-home-page.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { InstructorCalendarComponent } from './components/instructor-calendar/instructor-calendar.component';
import { InstructorLessonsComponent } from './components/instructor-lessons/instructor-lessons.component';
import { InstructorOneLessonComponent } from './components/instructor-one-lesson/instructor-one-lesson.component';


import {MatDialogModule} from '@angular/material/dialog';
import {MatTableModule} from '@angular/material/table';
import {MatButtonModule} from '@angular/material/button';
import { InstructorAddLessonComponent } from './components/instructor-add-lesson/instructor-add-lesson.component';
import { AdministratorHomePageComponent } from './components/administrator-home-page/administrator-home-page.component';
import { AdministratorRegistrationRequestsComponent } from './components/administrator-registration-requests/administrator-registration-requests.component';
import { AdministratorRegisterAdministratorComponent } from './components/administrator-register-administrator/administrator-register-administrator.component';
import { AdministratorUsersViewComponent } from './components/administrator-users-view/administrator-users-view.component';
import { UserProfileComponent } from './components/user-profile/user-profile.component';
import { InstructorAdditionalServiceDialogComponent } from './components/instructor-additional-service-dialog/instructor-additional-service-dialog.component';
import { UserSettingsComponent } from './components/user-settings/user-settings.component';
import { ChangePasswordDialogComponent } from './components/user-settings/change-password-dialog/change-password-dialog.component';
import { DeleteAccountDialogComponent } from './components/user-settings/delete-account-dialog/delete-account-dialog.component';
import { AdministratorLessonsViewComponent } from './components/administrator-lessons-view/administrator-lessons-view.component';
import { AdministratorDeleteAccountRequestsViewComponent } from './components/administrator-delete-account-requests-view/administrator-delete-account-requests-view.component';
import { InstructorLessonReservationsViewComponent } from './components/instructor-lesson-reservations-view/instructor-lesson-reservations-view.component';
import { InstructorOneLessonDetailComponent } from './components/instructor-one-lesson-detail/instructor-one-lesson-detail.component';
import { InstructorReportDialogComponent } from './components/instructor-lesson-reservations-view/instructor-report-dialog/instructor-report-dialog.component';
import { InstructorAddAdventureReservationDialogComponent } from './components/instructor-lesson-reservations-view/instructor-add-adventure-reservation-dialog/instructor-add-adventure-reservation-dialog.component';
import { ActionAdventureCreateDialogComponent } from './components/instructor-one-lesson-detail/action-adventure-create-dialog/action-adventure-create-dialog.component';
import { InstructorStatisticsComponent } from './components/instructor-statistics/instructor-statistics.component';
import { InstructorClientInfoDialogComponent } from './components/instructor-lesson-reservations-view/instructor-client-info-dialog/instructor-client-info-dialog.component';
import { AdministratorCottagesViewComponent } from './components/administrator-cottages-view/administrator-cottages-view.component';
import { AdministratorShipsViewComponent } from './components/administrator-ships-view/administrator-ships-view.component';
import { AdministratorUsersComplaintsComponent } from './components/administrator-users-complaints/administrator-users-complaints.component';
import { WriteAnswerDialogComponent } from './components/administrator-users-complaints/write-answer-dialog/write-answer-dialog.component';

@NgModule({
  declarations: [
    AppComponent,
    InstructorHomePageComponent,
    InstructorCalendarComponent,
    InstructorLessonsComponent,
    InstructorOneLessonComponent,
    InstructorAddLessonComponent,
    AdministratorHomePageComponent,
    AdministratorRegistrationRequestsComponent,
    AdministratorRegisterAdministratorComponent,
    AdministratorUsersViewComponent,
    AdministratorLessonsViewComponent,
    UserProfileComponent,
    InstructorAdditionalServiceDialogComponent,
    UserSettingsComponent,
    ChangePasswordDialogComponent,
    DeleteAccountDialogComponent,
    AdministratorDeleteAccountRequestsViewComponent,
    InstructorLessonReservationsViewComponent,
    InstructorOneLessonDetailComponent,
    InstructorReportDialogComponent,
    InstructorAddAdventureReservationDialogComponent,
    ActionAdventureCreateDialogComponent,
    InstructorStatisticsComponent,
    InstructorClientInfoDialogComponent,
    AdministratorCottagesViewComponent,
    AdministratorShipsViewComponent,
    AdministratorUsersComplaintsComponent,
    WriteAnswerDialogComponent
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
