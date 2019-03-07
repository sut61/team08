import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})
export class ReportService {

  public API = '//localhost:8080';

  constructor(private http : HttpClient) {}

  public getDoctor(): Observable<any> {
    return this.http.get(this.API +'/DoctorSelec');
  }

  public getPatient(): Observable<any> {
    return this.http.get(this.API +'/PatientSelec');
  }

  public getMedicaltechnique(): Observable<any> {
    return this.http.get(this.API +'/MedicaltechniqueSelec');
  }
  public getDepartment(): Observable<any> {
    return this.http.get(this.API +'/DepartmentSelec');
  }


  public getReportlab(): Observable<any> {
    return this.http.get(this.API +'/Reportlab');
  }
}
