import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable({providedIn: 'root'})
export class RegisterController {
  public API = '//localhost:8080';

  constructor(private http : HttpClient){}

    public  getSex(): Observable<any> {
        return this.http.get(this.API + '/sexes');
    }
    public  getRegister(): Observable<any> {
        return this.http.get(this.API + '/patients');
    }
    public  getPatienttype(): Observable<any> {
        return this.http.get(this.API + '/patienttypes');
    }
    public  getProvince(): Observable<any> {
        return this.http.get(this.API + '/provinces');
    }
}
