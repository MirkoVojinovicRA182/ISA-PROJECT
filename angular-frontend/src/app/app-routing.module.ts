import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdministratorDeleteAccountRequestsViewComponent } from './components/administrator-delete-account-requests-view/administrator-delete-account-requests-view.component';
import { AdministratorLessonsViewComponent } from './components/administrator-lessons-view/administrator-lessons-view.component';
import { AdministratorRegisterAdministratorComponent } from './components/administrator-register-administrator/administrator-register-administrator.component';
import { AdministratorRegistrationRequestsComponent } from './components/administrator-registration-requests/administrator-registration-requests.component';
import { AdministratorUsersViewComponent } from './components/administrator-users-view/administrator-users-view.component';
import { InstructorLessonsComponent } from './components/instructor-lessons/instructor-lessons.component';
import { MyTestComponent } from './components/my-test/my-test.component';
import { UserProfileComponent } from './components/user-profile/user-profile.component';
import { UserSettingsComponent } from './components/user-settings/user-settings.component';
import { Instructor } from './model/instructor';

const routes: Routes = [

  // ADMINSTRATOR ROUTES

  { path: 'registrationRequests', component: AdministratorRegistrationRequestsComponent },
  { path: 'adminRegistration', component: AdministratorRegisterAdministratorComponent },
  { path: 'users', component: AdministratorUsersViewComponent },
  { path: 'lessons', component: AdministratorLessonsViewComponent },
  {path: 'deleteAcountRequests', component: AdministratorDeleteAccountRequestsViewComponent},

  // INSTRUCTOR ROUTES
  { path: 'instructorLessons', component: InstructorLessonsComponent },
  { path: 'instructorLessons/:id', component: MyTestComponent },

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
