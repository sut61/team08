import { Component, OnInit } from '@angular/core';
import { LogingService, User} from '../../shared/loging/loging.service';
@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  constructor(
    private logingServie: LogingService
  ){}
  ngOnInit(){
  }

  logout(){
    this.logingServie.logout();
  }
}
