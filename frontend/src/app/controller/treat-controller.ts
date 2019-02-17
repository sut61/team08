import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})

export class TreatService {
  public API = '//localhost:8080';

  constructor(private httpClient: HttpClient) { }
  getRegister(): Observable<any> {
    return this.httpClient.get(this.API + '/patients');
  }
  getDoctor(): Observable<any> {
    return this.httpClient.get(this.API + '/doctor');
  }
  getMedicine(): Observable<any> {
    return this.httpClient.get(this.API + '/medicine');
  }
  getTreatHistory(): Observable<any> {
    return this.httpClient.get(this.API + '/treathistory');
  }
}
