import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdministratorCottagesViewComponent } from './components/administrator-components/administrator-cottages-view/administrator-cottages-view.component';
import { OwnerRegistrationComponent } from './components/unregistered-user-components/owner-registration/owner-registration.component';
import { UserSettingsComponent } from './components/unregistered-user-components/user-settings/user-settings.component';
import { Instructor } from './model/instructor';
import { Cottage } from './model/cottage';
import { CottageComponent } from './components/cottage-owner-components/cottage/cottage.component';
import { AdministratorDeleteAccountRequestsViewComponent } from './components/administrator-components/administrator-delete-account-requests-view/administrator-delete-account-requests-view.component';
import { AdministratorHomePageComponent } from './components/administrator-components/administrator-home-page/administrator-home-page.component';
import { AdministratorLessonsViewComponent } from './components/administrator-components/administrator-lessons-view/administrator-lessons-view.component';
import { AdministratorRegisterAdministratorComponent } from './components/administrator-components/administrator-register-administrator/administrator-register-administrator.component';
import { AdministratorRegistrationRequestsComponent } from './components/administrator-components/administrator-registration-requests/administrator-registration-requests.component';
import { AdministratorShipsViewComponent } from './components/administrator-components/administrator-ships-view/administrator-ships-view.component';
import { AdministratorStatisticsComponent } from './components/administrator-components/administrator-statistics/administrator-statistics.component';
import { AdministratorUsersComplaintsComponent } from './components/administrator-components/administrator-users-complaints/administrator-users-complaints.component';
import { AdministratorUsersViewComponent } from './components/administrator-components/administrator-users-view/administrator-users-view.component';
import { CottageOwnerHomePageComponent } from './components/cottage-owner-components/cottage-owner-home-page/cottage-owner-home-page.component';
import { CottagesPreviewComponent } from './components/cottage-owner-components/cottages-preview/cottages-preview.component';
import { InstructorHomePageComponent } from './components/instructor-components/instructor-home-page/instructor-home-page/instructor-home-page.component';
import { InstructorLessonReservationsViewComponent } from './components/instructor-components/instructor-lesson-reservations-view/instructor-lesson-reservations-view.component';
import { InstructorLessonsComponent } from './components/instructor-components/instructor-lessons/instructor-lessons.component';
import { InstructorOneLessonDetailComponent } from './components/instructor-components/instructor-one-lesson-detail/instructor-one-lesson-detail.component';
import { InstructorStatisticsComponent } from './components/instructor-components/instructor-statistics/instructor-statistics.component';
import { LandingPageComponent } from './components/unregistered-user-components/landing-page/landing-page.component';
import { LoginComponent } from './components/unregistered-user-components/login/login.component';
import { UserProfileComponent } from './components/unregistered-user-components/user-profile/user-profile.component';
import { CottageOwnerDefaultComponent } from './components/cottage-owner-components/cottage-owner-default/cottage-owner-default.component';
import { AllCottagesComponent } from './components/unregistered-user-components/all-cottages/all-cottages.component';
import { AllAdventuresComponent } from './components/unregistered-user-components/all-adventures/all-adventures.component';
import { AllShipsComponent } from './components/unregistered-user-components/all-ships/all-ships.component';
import { ClientHomePageComponent } from './components/client-components/client-home-page/client-home-page.component';
import { ClientProfileComponent } from './components/client-components/client-profile/client-profile.component';
import { ClientReservationsComponent } from './components/client-components/client-entities/client-reservations.component';
import { ClientCottageComponent } from './components/client-components/client-cottage/client-cottage.component';
import { ClientAdventureComponent } from './components/client-components/client-adventure/client-adventure.component';
import { ClientShipComponent } from './components/client-components/client-ship/client-ship.component';
import { ReservationsComponent } from './components/client-components/reservations/reservations.component';

const routes: Routes = [

  { path: '',   redirectTo: '/landingPage/login', pathMatch: 'full' },
  {
    path: 'landingPage',
    component: LandingPageComponent,

    children: [
      {
        path: 'login',
        component: LoginComponent
      },
      {
        path: 'registration',
        component: OwnerRegistrationComponent
      },
      {
        path: 'allCottages',
        component: AllCottagesComponent
      },
      {
        path: 'allAdventures',
        component: AllAdventuresComponent
      },
      {
        path: 'allShips',
        component: AllShipsComponent
      },
      {
        path: 'instructorLessons/:id',
        component: InstructorOneLessonDetailComponent
      },
    ]
  },

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
        path: 'adminStatistics',
        component: AdministratorStatisticsComponent
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
        path: 'instructorStatistics',
        component: InstructorStatisticsComponent
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

  // COTTAGE OWNER ROUTES

  {
    path: 'cottageOwner',
    component: CottageOwnerHomePageComponent,
    children: [
      {
        path: '',
        component: CottageOwnerDefaultComponent
      },
      {
        path: 'cottagesPreview',
        component: CottagesPreviewComponent
      },
      {
        path: 'cottageDetails',
        component: CottageComponent
      },
    ]
  },

  // CLIENT ROUTES
  {
    path: 'client',
    component: ClientHomePageComponent,

    children: [
      {
        path: 'profile',
        component: ClientProfileComponent
      },
      {
        path: 'home',
        component: ClientReservationsComponent,
      },
      {
        path: 'cottageDetails',
        component: ClientCottageComponent
      },
      {
        path: 'adventureDetails',
        component: ClientAdventureComponent
      },
      {
        path: 'shipDetails',
        component: ClientShipComponent
      },
      {
        path: 'reservations',
        component: ReservationsComponent
      }
    ]
  },

  // PROFILE ROUTES
  {
    path: 'profile',
    component: UserProfileComponent
  },
  { 
    path: 'settings', 
    component: UserSettingsComponent 
  }

];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
