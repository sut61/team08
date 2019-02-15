import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import {
        MatInputModule,
        MatCardModule,
        MatButtonModule,
        MatCheckboxModule,
        MatDatepickerModule,
        MatListModule,
        MatToolbarModule,
        MatGridListModule,
        MatProgressSpinnerModule,
        MatTableModule,
        MatSelectModule,
        MatOptionModule,
        MatFormFieldModule,
        MatRadioModule,
        MatNativeDateModule
} from '@angular/material/';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { MatMenuModule } from '@angular/material/menu';
import { RegisterController } from 'src/app/controller/register-controller';
import { AppRoutingModule } from './app-routing.module';
import { LoginComponent } from './login/login.component';
import { MatDialogModule} from '@angular/material/dialog';
import { MainpageComponent } from './mainpage/mainpage.component';
import { OndutyComponent } from './onduty/onduty.component';
import { RequestComponent } from './request/request.component';
import { LogingComponent } from './components/loging/loging.component';
import { LogingService } from './shared/loging/loging.service';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HomeComponent } from './components/home/home.component';
import { HomemainComponent } from './components/homemain/homemain.component';
import { WorkScheduleRegComponent } from './components/workSchedule-reg/workSchedule-reg.component';
import { WorkScheduleRegService } from './shared/workSchedule-reg/workSchedule-reg.service';
import { SuggestionComponent } from './components/suggestion/suggestion.component';
import { SuggestionService } from './shared/suggestion/suggestion.service';
import { TreatComponent } from './treat/treat.component';


@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    LoginComponent,
    MainpageComponent,
    OndutyComponent,
    RequestComponent,
    LogingComponent,
    NavbarComponent,
    HomeComponent,
    HomemainComponent,
    WorkScheduleRegComponent,
    SuggestionComponent,
    TreatComponent
  ],
  imports: [
    HttpModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatListModule,
    MatGridListModule,
    MatToolbarModule,
    FormsModule,
    RouterModule,
    MatSelectModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatTableModule,
    MatCheckboxModule,
    MatProgressSpinnerModule,
    MatOptionModule,
    MatRadioModule
  ],
  providers: [
      LogingService,
      WorkScheduleRegService,
      SuggestionService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
