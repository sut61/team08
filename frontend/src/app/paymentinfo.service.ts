import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})
export class PaymentinfoService {

  public API = '//localhost:8080';

  constructor(private http : HttpClient) {}

  public getNurse(): Observable<any> {
    return this.http.get(this.API +'/Nurse');
  }

  public getPayer(): Observable<any> {
    return this.http.get(this.API +'/Payer');
  }

  public getPayType(): Observable<any> {
    return this.http.get(this.API +'/PayType');
  }

  public getPaymentStatus(): Observable<any> {
    return this.http.get(this.API +'/PaymentStatus');
  }



}
