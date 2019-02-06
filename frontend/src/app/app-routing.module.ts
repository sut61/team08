import { NgModule } from '@angular/core';
import {  Routes,RouterModule } from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { MainpageComponent } from './mainpage/mainpage.component';
import { OndutyComponent } from './onduty/onduty.component';

const routes: Routes = [
  { path: 'register', component: RegisterComponent },
  { path: 'login', component: LoginComponent  },
  { path: 'mainpage', component: MainpageComponent },
  { path: 'onduty', component: OndutyComponent },
  { path: '',redirectTo: '/mainpage',pathMatch: 'full'},

];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }
