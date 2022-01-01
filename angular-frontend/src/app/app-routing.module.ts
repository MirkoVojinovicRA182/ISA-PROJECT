import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdministratorLessonsViewComponent } from './components/administrator-lessons-view/administrator-lessons-view.component';
import { AdministratorRegisterAdministratorComponent } from './components/administrator-register-administrator/administrator-register-administrator.component';
import { AdministratorRegistrationRequestsComponent } from './components/administrator-registration-requests/administrator-registration-requests.component';
import { AdministratorUsersViewComponent } from './components/administrator-users-view/administrator-users-view.component';
import { InstructorLessonsComponent } from './components/instructor-lessons/instructor-lessons.component';
import { InstructorSettingsComponent } from './components/instructor-settings/instructor-settings/instructor-settings.component';
import { UserProfileComponent } from './components/user-profile/user-profile.component';
import { Instructor } from './model/instructor';

const routes: Routes = [

  // ADMINSTRATOR ROUTES

  { path: 'registrationRequests', component: AdministratorRegistrationRequestsComponent },
  { path: 'adminRegistration', component: AdministratorRegisterAdministratorComponent },
  { path: 'users', component: AdministratorUsersViewComponent },
  { path: 'lessons', component: AdministratorLessonsViewComponent },

  // INSTRUCTOR ROUTES
  { path: 'instructorLessons', component: InstructorLessonsComponent },
  { path: 'instructorSettings', component: InstructorSettingsComponent },

  // PROFILE ROUTE
  { path: 'profile', component: UserProfileComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
