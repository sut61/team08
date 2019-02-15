import { TreatService } from './../controller/treat-controller';
import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-treat',
  templateUrl: './treat.component.html',
  styleUrls: ['./treat.component.css']
})
export class TreatComponent implements OnInit {

  pressure: number;
  weight: number;
  symptom: string;
  dateSelect = null;


  medicine: Array<any>;
  medicineSelect = '';

  doctor: Array<any>;
  doctorSelect = '';

  patient: Array<any>;
  patientSelect = '';

  constructor(private treatService: TreatService, private httpClient: HttpClient) { }

  ngOnInit() {
    this.treatService.getPatient().subscribe(data => {
      this.patient = data;
      console.log(this.patient);
    });
    this.treatService.getMedicine().subscribe(data => {
      this.medicine = data;
      console.log(this.medicine);
    });
    this.treatService.getDoctor().subscribe(data => {
      this.doctor = data;
      console.log(this.doctor);
    });
  }


//   if (this.patientSelect == null || this.pressure == null || this.weight == null ||
//     this.symptom == null || this.dateSelect == null || this.medicineSelect == null || this.doctorSelect == null) {
//     alert('กรุณาใส่ข้อมูลให้ครบ');
//  }

  insert() {
    if (this.patientSelect == null || this.pressure == null || this.weight == null ||
       this.symptom == null || this.dateSelect == null || this.medicineSelect == null || this.doctorSelect == null) {
           alert('กรุณาใส่ข้อมูลให้ครบ');
       } else {
      this.httpClient.post('http://localhost:8080/treathistory/' + this.patientSelect + '/' + this.pressure +
      '/' + this.weight + '/' + this.symptom + '/' + this.dateSelect +
      '/' + this.medicineSelect + '/' + this.doctorSelect, {})
      .subscribe();
      alert('สำเร็จ');
       }
    }
  }
