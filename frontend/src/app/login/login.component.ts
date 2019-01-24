import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { HttpClient} from '@angular/common/http';
import { LoginService } from 'src/app/login.service';
import { MatDialog } from '@angular/material';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private router: Router , private httpClient: HttpClient , private app: LoginService){  }

  Doctor: any={
    doctorname: '',
    password: ''
  }
  check:any='';

  ngOnInit() {}
  login() {
    if(this.Doctor.doctorname === '' && this.Doctor.password === ''){
        alert("กรุณากรอกข้อมูลให้ครบถ้อน");

      }else {
        this.httpClient.get('http://localhost:8080/doctor/'+this.Doctor.doctorname+'/'+this.Doctor.password,{})
        .subscribe(data => {
          this.check = data;
          console.log('PUT Request is successful',data);
          if(this.check === true){
            this.router.navigate(["register"]);
          }
          else{
            alert('Username หรือ Password ไม่ถูกต้อง')
          }
        },
        error => {
          console.log('Error',error);
        }
        );
      }
  }
}
