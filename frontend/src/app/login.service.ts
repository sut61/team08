import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class LoginService {
  public API = '//localhost:8080';

  constructor(private http: HttpClient) {}

  getSymptom() : Observable<any>{
    return this.http.get(this.API+'/Doctor');
  }

}
