import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RequestformController {
  public API = '//localhost:8080';

  constructor(private httpClient: HttpClient) { }
  getDepartment(): Observable<any> {
    return this.httpClient.get(this.API + '/department');
  }
  getDoctor(): Observable<any> {
    return this.httpClient.get(this.API + '/doctor');
  }
  getApprover(): Observable<any> {
    return this.httpClient.get(this.API + '/approver');
  }
  getSurrogate(): Observable<any> {
    return this.httpClient.get(this.API + '/surrogate');
  }
  getTool(): Observable<any> {
    return this.httpClient.get(this.API + '/tool');
  }
  getRequestForm(): Observable<any> {
    return this.httpClient.get(this.API + '/requestform');
  }
}
