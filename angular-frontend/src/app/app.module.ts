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

@NgModule({
  declarations: [
    AppComponent,
    InstructorHomePageComponent,
    InstructorProfileInfoComponent,
    InstructorSettingsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
