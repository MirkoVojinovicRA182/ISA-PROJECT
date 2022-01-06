import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdministratorDeleteAccountRequestsViewComponent } from './components/administrator-delete-account-requests-view/administrator-delete-account-requests-view.component';
import { AdministratorLessonsViewComponent } from './components/administrator-lessons-view/administrator-lessons-view.component';
import { AdministratorRegisterAdministratorComponent } from './components/administrator-register-administrator/administrator-register-administrator.component';
import { AdministratorRegistrationRequestsComponent } from './components/administrator-registration-requests/administrator-registration-requests.component';
import { AdministratorUsersViewComponent } from './components/administrator-users-view/administrator-users-view.component';
import { InstructorLessonReservationsViewComponent } from './components/instructor-lesson-reservations-view/instructor-lesson-reservations-view.component';
import { InstructorLessonsComponent } from './components/instructor-lessons/instructor-lessons.component';
import { InstructorOneLessonDetailComponent } from './components/instructor-one-lesson-detail/instructor-one-lesson-detail.component';
import { UserProfileComponent } from './components/user-profile/user-profile.component';
import { UserSettingsComponent } from './components/user-settings/user-settings.component';

const routes: Routes = [

  // ADMINSTRATOR ROUTES

  { path: 'registrationRequests', component: AdministratorRegistrationRequestsComponent },
  { path: 'adminRegistration', component: AdministratorRegisterAdministratorComponent },
  { path: 'users', component: AdministratorUsersViewComponent },
  { path: 'lessons', component: AdministratorLessonsViewComponent },
  {path: 'deleteAcountRequests', component: AdministratorDeleteAccountRequestsViewComponent},

  // INSTRUCTOR ROUTES
  { path: 'instructorLessons', component: InstructorLessonsComponent },
  { path: 'instructorLessons/:id', component: InstructorOneLessonDetailComponent },
  { path: 'instructorReservations', component: InstructorLessonReservationsViewComponent },

  // PROFILE ROUTES
  { path: 'profile', component: UserProfileComponent },
  { path: 'settings', component: UserSettingsComponent },

];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
