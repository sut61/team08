import { RequestformController } from './../controller/requestform-controller';
import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-request',
  templateUrl: './request.component.html',
  styleUrls: ['./request.component.css']
})
export class RequestComponent implements OnInit {
  department: Array<any>;
  departmentSelect = '';
  doctor: Array<any>;
  doctorSelect = '';
  tool: Array<any>;
  toolSelect = '';
  surrogate: Array<any>;
  surrogateSelect = '';
  approver: Array<any>;
  approverSelect = '';

  dateSelect = null;
  amount: number;
  objective: string;
  sgname: string;



  constructor(private requestformController: RequestformController, private httpClient: HttpClient) { }

  ngOnInit() {
    this.requestformController.getDepartment().subscribe(data => {
      this.department = data;
      console.log(this.department);
    });
    this.requestformController.getApprover().subscribe(data => {
      this.approver = data;
      console.log(this.approver);
    });
    this.requestformController.getDoctor().subscribe(data => {
      this.doctor = data;
      console.log(this.doctor);
    });
    this.requestformController.getSurrogate().subscribe(data => {
      this.surrogate = data;
      console.log(this.surrogate);
    });
    this.requestformController.getTool().subscribe(data => {
      this.tool = data;
      console.log(this.tool);
    });
}
  submit() {
    if (this.departmentSelect == null || this.toolSelect == null || this.amount == null ||
      this.dateSelect == null  || this.surrogateSelect == null ||
      this.sgname == null || this.doctorSelect == null ||   this.approverSelect == null ) {
        alert('กรุณาใส่ข้อมูล');
      } else {
        this.httpClient.post('http://localhost:8080/requestform/'
         + this.departmentSelect + '/' +  this.toolSelect + '/' +   this.amount + '/' + this.dateSelect + '/' +
         this.objective  + '/' + this.surrogateSelect  + '/' + this.sgname  + '/' + this.doctorSelect + '/' +   this.approverSelect, {})
        .subscribe();
        alert('สำเร็จ');
      }
  }
}
