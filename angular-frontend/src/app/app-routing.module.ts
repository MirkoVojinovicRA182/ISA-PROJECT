import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdministratorCottagesViewComponent } from './components/administrator-cottages-view/administrator-cottages-view.component';
import { AdministratorDeleteAccountRequestsViewComponent } from './components/administrator-delete-account-requests-view/administrator-delete-account-requests-view.component';
import { AdministratorHomePageComponent } from './components/administrator-home-page/administrator-home-page.component';
import { AdministratorLessonsViewComponent } from './components/administrator-lessons-view/administrator-lessons-view.component';
import { AdministratorRegisterAdministratorComponent } from './components/administrator-register-administrator/administrator-register-administrator.component';
import { AdministratorRegistrationRequestsComponent } from './components/administrator-registration-requests/administrator-registration-requests.component';
import { AdministratorShipsViewComponent } from './components/administrator-ships-view/administrator-ships-view.component';
import { AdministratorUsersComplaintsComponent } from './components/administrator-users-complaints/administrator-users-complaints.component';
import { AdministratorUsersViewComponent } from './components/administrator-users-view/administrator-users-view.component';
import { InstructorHomePageComponent } from './components/instructor-home-page/instructor-home-page/instructor-home-page.component';
import { InstructorLessonReservationsViewComponent } from './components/instructor-lesson-reservations-view/instructor-lesson-reservations-view.component';
import { InstructorLessonsComponent } from './components/instructor-lessons/instructor-lessons.component';
import { InstructorOneLessonDetailComponent } from './components/instructor-one-lesson-detail/instructor-one-lesson-detail.component';
import { InstructorStatisticsComponent } from './components/instructor-statistics/instructor-statistics.component';
import { LandingPageComponent } from './components/landing-page/landing-page.component';
import { OwnerRegistrationComponent } from './components/owner-registration/owner-registration.component';
import { UserProfileComponent } from './components/user-profile/user-profile.component';
import { UserSettingsComponent } from './components/user-settings/user-settings.component';

const routes: Routes = [

  // WELCOME ROUTES
  { path: 'welcome', component: LandingPageComponent },
  { path: '', redirectTo: 'welcome', pathMatch: 'full' },

  // ADMINSTRATOR ROUTES

  { 
    path: 'admin', 
    component: AdministratorHomePageComponent,

    children: [
      {
          path: 'registrationRequests',
          component: AdministratorRegistrationRequestsComponent
      },
      {
        path: 'adminRegistration',
        component: AdministratorRegisterAdministratorComponent
      },
      {
        path: 'users',
        component: AdministratorUsersViewComponent
      },
      {
        path: 'lessons',
        component: AdministratorLessonsViewComponent
      },
      {
        path: 'deleteAcountRequests',
        component: AdministratorDeleteAccountRequestsViewComponent
      },
      {
        path: 'cottages',
        component: AdministratorCottagesViewComponent
      },
      {
        path: 'ships',
        component: AdministratorShipsViewComponent
      },
      {
        path: 'complaints',
        component: AdministratorUsersComplaintsComponent
      },
      {
        path: 'profile',
        component: UserProfileComponent
      }
  ]
  
  },

  // INSTRUCTOR ROUTES
  { 
    path: 'instructor', 
    component: InstructorHomePageComponent,

    children: [
      {
        path: 'instructorLessons',
        component: InstructorLessonsComponent
      },
      {
        path: 'instructorLessons/:id',
        component: InstructorOneLessonDetailComponent
      },
      {
        path: 'instructorReservations',
        component: InstructorLessonReservationsViewComponent
      },
      {
        path: 'profile',
        component: UserProfileComponent
      },
      {
        path: 'settings',
        component: UserSettingsComponent
      }
    ]
  },

  // REGISTRATION ROUTES
  { path: 'registration', component: OwnerRegistrationComponent },

  // PROFILE ROUTES
  { path: 'profile', component: UserProfileComponent },
  { path: 'settings', component: UserSettingsComponent }

];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
