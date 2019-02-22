import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})
export class MediscriptService {

  public API = '//localhost:8080';

  constructor(private http : HttpClient) {}

  public getDoctor(): Observable<any> {
    return this.http.get(this.API +'/Doctor');
  }

  public getCompany(): Observable<any> {
    return this.http.get(this.API +'/Company');
  }

  public getMedi(): Observable<any> {
    return this.http.get(this.API +'/Medi');
  }

}
