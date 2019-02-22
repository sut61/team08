import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { MediscriptService } from '../mediscript.service';
@Component({
  selector: 'app-mediscript',
  templateUrl: './mediscript.component.html',
  styleUrls: ['./mediscript.component.css']
})
export class MediscriptComponent implements OnInit {
  doctor: Array<any>;
  DoctorSelecte: any ='';
  amountMedi='';
  CompanyName: Array<any>;
  CompanyNameSelect: any ='';
  MediName: Array<any>;
  MediNameSelect: any ='';

  constructor(private mediscriptService:  MediscriptService,
                            private httpClient: HttpClient) { }

  ngOnInit() {

  this.mediscriptService.getCompany().subscribe(data => {
        this.CompanyName = data;
        console.log(this.CompanyName);
      });
      this.mediscriptService.getDoctor().subscribe(data => {
        this.doctor = data;
        console.log(this.doctor);
      });
     this.mediscriptService.getMedi().subscribe(data=>{
             this.MediName =  data;
             console.log(this.MediName);
         })
  }

insert() {
  if (this.MediNameSelect == '' || this.CompanyNameSelect == '' ||  this.DoctorSelecte == '' || this.amountMedi =='' ) {
        alert('ใส่ข้อมูลไม่ครบจะไม่ถูกบันทึกนะ');
    } else {
         this.httpClient.post('http://localhost:8080/Mediscript/' + this.MediNameSelect + '/' + this.CompanyNameSelect +'/'  + this.DoctorSelecte +'/'  + this.amountMedi ,{})
     .subscribe(
       data => {
         console.log('PUT Request is successful', data);
        },
        error => {
          console.log('Error', error);
        }
      );
    alert('บันทึกข้อมูลเรียบร้อย');
  }
}






  }
