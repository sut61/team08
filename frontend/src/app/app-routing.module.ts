import { NgModule } from '@angular/core';
import {  Routes,RouterModule } from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { MainpageComponent } from './mainpage/mainpage.component';
import { OndutyComponent } from './onduty/onduty.component';
import { RequestComponent } from './request/request.component';
import { WorkScheduleRegComponent } from './components/workSchedule-reg/workSchedule-reg.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HomeComponent } from './components/home/home.component';
import { HomemainComponent } from './components/homemain/homemain.component';
import { LogingComponent } from './components/loging/loging.component';
import { SuggestionComponent } from './components/suggestion/suggestion.component';

const routes: Routes = [
  { path: '',redirectTo: '/homemain',pathMatch: 'full'},
  { path: 'register', component: RegisterComponent },
  { path: 'login', component: LoginComponent  },
  { path: 'mainpage', component: MainpageComponent },
  { path: 'onduty', component: OndutyComponent },
  { path: 'request', component: RequestComponent },
  {path: 'loging', component: LogingComponent},
  {path: 'home', component: HomeComponent},
  {path: 'homemain', component: HomemainComponent},
  {path: 'workSchedule-register', component: WorkScheduleRegComponent},
  {path: 'suggestion', component: SuggestionComponent}

];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }
