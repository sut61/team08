import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  public API = '//localhost:8080';

  constructor(private http : HttpClient) {}

  public getDoctor(): Observable<any> {
    return this.http.get(this.API +'/DoctorSelectt');
  }

  public getPatient(): Observable<any> {
    return this.http.get(this.API +'/PatientSelectt');
  }

  public getMedicaltechnique(): Observable<any> {
    return this.http.get(this.API +'/MedicaltechniqueSelectt');
  }
  public getOrderlab(): Observable<any> {
    return this.http.get(this.API +'/Orderlab');
  }
}
