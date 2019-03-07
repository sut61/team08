import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { OrderService } from '../order.service';
@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {
  doctor: Array<any>;
  DoctorSelectt: any ='';
  ordername='';
  note='';
  patient: Array<any>;
  PatientSelectt: any ='';
  medicaltechnique: Array<any>;
  MedicaltechniqueSelectt: any ='';

  constructor(private orderService:  OrderService,
                            private httpClient: HttpClient) { }

  ngOnInit() {

  this.orderService.getPatient().subscribe(data => {
        this.patient = data;
        console.log(this.patient);
      });
      this.orderService.getDoctor().subscribe(data => {
        this.doctor = data;
        console.log(this.doctor);
      });
     this.orderService.getMedicaltechnique().subscribe(data=>{
             this.medicaltechnique =  data;
             console.log(this.medicaltechnique);
         })
  }

insert() {
  if (this.MedicaltechniqueSelectt == '' || this.PatientSelectt == '' ||  this.DoctorSelectt == '' || this.ordername =='' || this.note =='' ) {
        alert('ใส่ข้อมูลไม่ครบจะไม่ถูกบันทึกนะ');
    } else {
         this.httpClient.post('http://localhost:8080/Orderlab/' + this.MedicaltechniqueSelectt + '/' + this.PatientSelectt +'/'  + this.DoctorSelectt +'/'  + this.ordername +  '/'  + this.note,{})
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
