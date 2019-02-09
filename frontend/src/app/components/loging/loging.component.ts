import { Component, OnInit } from '@angular/core';
import { LogingService, User} from '../../shared/loging/loging.service';
@Component({
  selector: 'app-loging',
  templateUrl: './loging.component.html',
  styleUrls: ['./loging.component.css']
})
export class LogingComponent implements OnInit {
  
  user: User = new User();
  constructor(
    private logingServie: LogingService
  ){}

  ngOnInit() {
  }

  loging(){
    this.logingServie.loging(this.user);
  }
}
