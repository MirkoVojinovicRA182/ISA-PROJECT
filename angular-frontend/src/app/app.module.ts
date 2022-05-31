import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';


import {MatDialogModule} from '@angular/material/dialog';
import {MatTableModule} from '@angular/material/table';
import {MatButtonModule} from '@angular/material/button';
import { InstructorAddLessonComponent } from './components/instructor-components/instructor-add-lesson/instructor-add-lesson.component';
import { UserSettingsComponent } from './components/unregistered-user-components/user-settings/user-settings.component';
import { ChangePasswordDialogComponent } from './components/unregistered-user-components/user-settings/change-password-dialog/change-password-dialog.component';
import { DeleteAccountDialogComponent } from './components/unregistered-user-components/user-settings/delete-account-dialog/delete-account-dialog.component';
import { AdministratorCottagesViewComponent } from './components/administrator-components/administrator-cottages-view/administrator-cottages-view.component';
import { OwnerRegistrationComponent } from './components/owner-registration/owner-registration.component';
import { CottageComponent } from './components/cottage-owner-components/cottage/cottage.component';
import { AdministratorDeleteAccountRequestsViewComponent } from './components/administrator-components/administrator-delete-account-requests-view/administrator-delete-account-requests-view.component';
import { AdministratorHomePageComponent } from './components/administrator-components/administrator-home-page/administrator-home-page.component';
import { AdministratorLessonsViewComponent } from './components/administrator-components/administrator-lessons-view/administrator-lessons-view.component';
import { AdministratorRegisterAdministratorComponent } from './components/administrator-components/administrator-register-administrator/administrator-register-administrator.component';
import { AdministratorRegistrationRequestsComponent } from './components/administrator-components/administrator-registration-requests/administrator-registration-requests.component';
import { EjectRegistrationRequestComponent } from './components/administrator-components/administrator-registration-requests/eject-registration-request/eject-registration-request.component';
import { AdministratorShipsViewComponent } from './components/administrator-components/administrator-ships-view/administrator-ships-view.component';
import { AdministratorStatisticsComponent } from './components/administrator-components/administrator-statistics/administrator-statistics.component';
import { AdministratorUsersComplaintsComponent } from './components/administrator-components/administrator-users-complaints/administrator-users-complaints.component';
import { WriteAnswerDialogComponent } from './components/administrator-components/administrator-users-complaints/write-answer-dialog/write-answer-dialog.component';
import { AdministratorUsersViewComponent } from './components/administrator-components/administrator-users-view/administrator-users-view.component';
import { NgxSliderModule } from '@angular-slider/ngx-slider';
import { IvyCarouselModule } from 'angular-responsive-carousel';
import { CottageOwnerHomePageComponent } from './components/cottage-owner-components/cottage-owner-home-page/cottage-owner-home-page.component';
import { CottagesPreviewComponent } from './components/cottage-owner-components/cottages-preview/cottages-preview.component';
import { InstructorAdditionalServiceDialogComponent } from './components/instructor-components/instructor-additional-service-dialog/instructor-additional-service-dialog.component';
import { InstructorCalendarComponent } from './components/instructor-components/instructor-calendar/instructor-calendar.component';
import { InstructorHomePageComponent } from './components/instructor-components/instructor-home-page/instructor-home-page/instructor-home-page.component';
import { InstructorAddAdventureReservationDialogComponent } from './components/instructor-components/instructor-lesson-reservations-view/instructor-add-adventure-reservation-dialog/instructor-add-adventure-reservation-dialog.component';
import { InstructorClientInfoDialogComponent } from './components/instructor-components/instructor-lesson-reservations-view/instructor-client-info-dialog/instructor-client-info-dialog.component';
import { InstructorLessonReservationsViewComponent } from './components/instructor-components/instructor-lesson-reservations-view/instructor-lesson-reservations-view.component';
import { InstructorReportDialogComponent } from './components/instructor-components/instructor-lesson-reservations-view/instructor-report-dialog/instructor-report-dialog.component';
import { InstructorLessonsComponent } from './components/instructor-components/instructor-lessons/instructor-lessons.component';
import { ActionAdventureCreateDialogComponent } from './components/instructor-components/instructor-one-lesson-detail/action-adventure-create-dialog/action-adventure-create-dialog.component';
import { InstructorOneLessonDetailComponent } from './components/instructor-components/instructor-one-lesson-detail/instructor-one-lesson-detail.component';
import { InstructorOneLessonComponent } from './components/instructor-components/instructor-one-lesson/instructor-one-lesson.component';
import { InstructorStatisticsComponent } from './components/instructor-components/instructor-statistics/instructor-statistics.component';
import { LandingPageComponent } from './components/unregistered-user-components/landing-page/landing-page.component';
import { LoginComponent } from './components/unregistered-user-components/login/login.component';
import { UserProfileComponent } from './components/unregistered-user-components/user-profile/user-profile.component';
import { UserReservationsStatisticsComponent } from './components/unregistered-user-components/user-reservations-statistics/user-reservations-statistics.component';
import { UserSallaryComponent } from './components/unregistered-user-components/user-sallary/user-sallary.component';
import { CottageOwnerDefaultComponent } from './components/cottage-owner-components/cottage-owner-default/cottage-owner-default.component';
import { CottageOwnerDeleteAccountComponent } from './components/cottage-owner-components/cottage-owner-delete-account/cottage-owner-delete-account.component';

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
    LoginComponent,
    LandingPageComponent,
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
    WriteAnswerDialogComponent,
    OwnerRegistrationComponent,
    LandingPageComponent,
    EjectRegistrationRequestComponent,
    UserSallaryComponent,
    AdministratorStatisticsComponent,
    UserReservationsStatisticsComponent,
    CottageOwnerHomePageComponent,
    CottagesPreviewComponent,
    CottageComponent,
    CottageOwnerDefaultComponent,
    CottageOwnerDeleteAccountComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,

    MatDialogModule,
    MatTableModule,
    MatButtonModule,
    NgxSliderModule,
    IvyCarouselModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
