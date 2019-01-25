import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Router } from '@angular/router';
import { RegisterController } from 'src/app/controller/register-controller';

export interface Age {
value: string;
viewValue: string;
}

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
  firstNameEnter='';
  lastNameEnter='';
  ages: Age[] = [
    {value: '0', viewValue: '0 ปี'},
    {value: '1', viewValue: '1 ปี'},
    {value: '2', viewValue: '2 ปี'}
  ];
  birthDay='';
  district='';
  subdistrict='';
  housenumber='';
  postcode='';
  patientdetail='';

  years='';

  constructor(private registerController: RegisterController , private httpClient: HttpClient , private router: Router) {}

  ngOnInit() {
    this.registerController.getPatienttype().subscribe(data => {
      this.patientType = data;
      console.log(this.patientType);
    });

    this.registerController.getProvince().subscribe(data => {
      this.provinceName = data;
      console.log(this.provinceName);
    });

    this.registerController.getSex().subscribe(data => {
      this.sexTitle = data;
      console.log(this.sexTitle);
    });
  }

  save() {
      this.httpClient.post('http://localhost:8080/register/' + this.provinceSelect + '/' + this.sexSelect + '/' + this.patienttypeSelect + '/' + this.firstNameEnter + '/' + this.lastNameEnter + '/' + this.years + '/' + this.birthDay + '/' + this.district + '/' + this.subdistrict + '/' + this.housenumber + '/' + this.postcode + '/' + this.patientdetail,{})
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
    console.log(this.firstNameEnter);
    console.log(this.lastNameEnter);
    console.log(this.years);
    console.log(this.birthDay);
    console.log(this.district);
    console.log(this.subdistrict);
    console.log(this.housenumber);
    console.log(this.postcode);
    console.log(this.patientdetail);
  }

}
