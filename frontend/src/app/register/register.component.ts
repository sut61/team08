import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { RegisterController } from 'src/app/controller/register-controller';
import { MatDatepickerModule } from '@angular/material/datepicker';

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
      this.httpClient.post('http://localhost:8080/Patient/' + this.provinceSelect + '/' + this.sexSelect + '/' + this.patienttypeSelect + '/' + this.firstNameEnter + '/' + this.lastNameEnter + '/' + this.years + '/' + this.district + '/' + this.subdistrict + '/' + this.housenumber + '/' + this.postcode + '/' + this.patientdetail,{})
      .subscribe(
        data => {
           console.log('PUT Request is successful', data);
           alert('บันทึกข้อมูล')
        },
        error => {
          console.log('Error', error);
          alert('error ไม่สามารถบันทึกข้อมูลได้')
        }
       );


  }

}
