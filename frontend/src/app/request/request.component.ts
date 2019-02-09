import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Router, ActivatedRoute } from '@angular/router';
import { RequestformController } from 'src/app/controller/requestform-controller';

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



  constructor(private controllerService: RequestformController, private httpClient: HttpClient) { }

  ngOnInit() {
    this.controllerService.getDepartment().subscribe(data => {
      this.department = data;
      console.log(this.department);
    });
    this.controllerService.getApprover().subscribe(data => {
      this.approver = data;
      console.log(this.approver);
    });
    this.controllerService.getDoctor().subscribe(data => {
      this.doctor = data;
      console.log(this.doctor);
    });
    this.controllerService.getSurrogate().subscribe(data => {
      this.surrogate = data;
      console.log(this.surrogate);
    });
    this.controllerService.getTool().subscribe(data => {
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
