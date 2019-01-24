import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Router } from '@angular/router';
import { RegisterController } from 'src/app/controller/register-controller';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  provinceName:Array<any>
  provinceSelect='';
  sexTitle:Array<any>
  sexSelect='';
  patientType:Array<any>
  patienttypeSelect='';


  constructor(private registerController: RegisterController , private httpClient: HttpClient , private router: Router) {}

  ngOnInit() {
    this.registerController.getPatienttype().subscribe(data => {
      this.provinceName = data;
      console.log(this.provinceName);
    });

    this.registerController.getProvince().subscribe(data => {
      this.sexTitle = data;
      console.log(this.sexTitle);
    });

    this.registerController.getSex().subscribe(data => {
      this.patientType = data;
      console.log(this.patientType);
    });
  }

  save() {

      this.httpClient.post('http://localhost:8080/register/' + this.provinceSelect + '/' + this.sexSelect + '/' + this.patienttypeSelect,{})
      .subscribe(
        data => {
           console.log('PUT Request is successful', data);
        },
        error => {
          console.log('Error', error);
        }
       );

    console.log(this.provinceSelect);
    console.log(this.sexSelect);
    console.log(this.patienttypeSelect);
  }

}
