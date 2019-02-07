import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable({providedIn: 'root'})
export class OndutyController {
  public API = '//localhost:8080';

  constructor(private http : HttpClient){}

    public  getLab(): Observable<any> {
        return this.http.get(this.API + '/labs');
    }
    public  getOnduty(): Observable<any> {
        return this.http.get(this.API + '/onduties');
    }
    public  getDoctor(): Observable<any> {
        return this.http.get(this.API + '/doctors');
    }
}
