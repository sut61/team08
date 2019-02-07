import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Router } from '@angular/router';
import { OndutyController } from 'src/app/controller/onduty-controller';

@Component({
  selector: 'app-onduty',
  templateUrl: './onduty.component.html',
  styleUrls: ['./onduty.component.css']
})
export class OndutyComponent implements OnInit {
  docTor:Array<any>
  doctorSelect='';
  labId:Array<any>
  labSelect = '';
  dailyreport='';
  sign='';
  brokenreport='';

  constructor(private ondutyController: OndutyController, private httpClient: HttpClient , private router: Router) { }

  ngOnInit() {
    this.ondutyController.getDoctor().subscribe(data => {
      this.docTor = data;
      console.log(this.docTor);
    });

    this.ondutyController.getLab().subscribe(data => {
      this.labId = data;
      console.log(this.labId);
    });
  }

  saveonduty() {
    if(this.doctorSelect === '' && this.labSelect === '' && this.dailyreport === '' && this.sign === '' && this.brokenreport === ''){
        alert("กรุณากรอกข้อมูลทุกอย่างให้ครบถ้อน");
    }else {
      this.httpClient.post('http://localhost:8080/onduty/' + this.doctorSelect + '/' + this.labSelect + '/' + this.dailyreport + '/' + this.sign + '/' + this.brokenreport,{})
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

    console.log(this.doctorSelect);
    console.log(this.labSelect);
    console.log(this.sign);
    console.log(this.dailyreport);
    console.log(this.brokenreport);
  }
}

