import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { PaymentinfoService } from '../paymentinfo.service';
@Component({
  selector: 'app-paymentinfo',
  templateUrl: './paymentinfo.component.html',
  styleUrls: ['./paymentinfo.component.css']
})
export class PaymentinfoComponent implements OnInit {
  NurseName: Array<any>;
  NurseNameSelecte: any ='';
  PayPrice='';
  PayerName: Array<any>;
  PayerNameSelect: any ='';
  PayTypeName: Array<any>;
  PayTypeNameSelect: any ='';
  PaymentStatusName: Array<any>;
  PaymentStatusNameSelect: any ='';
  Note='';
  TreatList='';
  MediList='';
  SpecialNote='';

  constructor(private paymentinfoService:  PaymentinfoService,
                            private httpClient: HttpClient) { }

  ngOnInit() {

  this.paymentinfoService.getPayer().subscribe(data => {
        this.PayerName = data;
        console.log(this.PayerName);
      });
      this.paymentinfoService.getNurse().subscribe(data => {
        this.NurseName = data;
        console.log(this.NurseName);
      });
     this.paymentinfoService.getPayType().subscribe(data=>{
             this.PayTypeName =  data;
             console.log(this.PayTypeName);
         })
    this.paymentinfoService.getPaymentStatus().subscribe(data => {
      this.PaymentStatusName = data;
      console.log(this.PaymentStatusName);
    });

  }

insert() {
  if (this.PayTypeNameSelect === '' || this.PayerNameSelect === '' ||  this.NurseNameSelecte === '' || this.PayPrice ==='' || this.PaymentStatusNameSelect === '' || this.Note ==='' || this.MediList ===''|| this.TreatList ==='' || this.SpecialNote ==='') {
        alert('ใส่ข้อมูลไม่ครบจะไม่ถูกบันทึกนะ');
    } else {
         this.httpClient.post('http://localhost:8080/PaymentInfo/' + this.PayTypeNameSelect + '/' + this.PayerNameSelect +'/'  + this.NurseNameSelecte +'/'  + this.PayPrice + '/' + this.PaymentStatusNameSelect + '/' + this.Note + '/' + this.MediList + '/' + this.TreatList + '/' + this.SpecialNote  ,{})
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
