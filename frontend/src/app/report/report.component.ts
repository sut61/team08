import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {ReportService } from '../report.service';
@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.css']
})
export class ReportComponent implements OnInit {
  doctor: Array<any>;
  DoctorSelec: any ='';


  description='';
  result_lab='';
  normal_range='';
  other='';


  patient: Array<any>;
  PatientSelec: any ='';

  medicaltechnique: Array<any>;
  MedicaltechniqueSelec: any ='';

  department: Array<any>;
  DepartmentSelec: any = '';

  constructor(private reportService:  ReportService,
                            private httpClient: HttpClient) { }

  ngOnInit() {

  this.reportService.getPatient().subscribe(data => {
        this.patient = data;
        console.log(this.patient);
      });
      this.reportService.getDoctor().subscribe(data => {
        this.doctor = data;
        console.log(this.doctor);
      });
     this.reportService.getMedicaltechnique().subscribe(data=>{
             this.medicaltechnique =  data;
             console.log(this.medicaltechnique);
         });
     this.reportService.getDepartment().subscribe(data=>{
      this.department =  data;
      console.log(this.department)
    });
  }

  insert() {
  if (this.MedicaltechniqueSelec == '' || this.PatientSelec == '' ||  this.DoctorSelec == '' || this.DepartmentSelec =='' || this.description =='' || this.result_lab == ''|| this.normal_range =='' || this.other =='' ) {
        alert('ใส่ข้อมูลไม่ครบจะไม่ถูกบันทึกนะ');
    } else {
         this.httpClient.post('http://localhost:8080/Reportlab/' + this.MedicaltechniqueSelec + '/' + this.PatientSelec +'/'  + this.DoctorSelec +'/'   + this.DepartmentSelec + '/' + this.description +  '/'  + this.result_lab + '/' + this.normal_range + '/' + this.other,{})
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
