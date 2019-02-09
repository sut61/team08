import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class WorkScheduleRegService {
  public API = '//localhost:8080';
  regis: WorkSchedule = new WorkSchedule();

  constructor(
    private http: HttpClient
  ) { }


  getStaff(): Observable<any>{
    return this.http.get(this.API + '/Staff');
  }
  getHealthLabs(): Observable<any>{
    return this.http.get(this.API + '/Health-Lab');
  }
  getStaffPositions(): Observable<any>{
    return this.http.get(this.API + '/StaffPosition');
  }
  getAllRegister(): Observable<any>{
    return this.http.get(this.API + '/WorkSchedule');
  }
  newStaff(staff: Staff): Observable<any>{
    return this.http.post(this.API + '/Staff', staff);
  }

  register(lab: HealthLab, staff: Staff, staffPosition: StaffPosition): Observable<any>{
    this.regis = new WorkSchedule();
    this.regis.staff = staff;
    this.regis.staffPosition = staffPosition;
    this.regis.healthLab = lab;
    return this.http.post(this.API + '/Register', this.regis);
  }
}

export class Staff{
  staffId: any;
  staffName: string;
  dayWork: string;
  workTime: string;
  labStaffId: string;
  tel: string;
}
export class HealthLab{
  sid: any;
  sname: string;
}
export class WorkSchedule{
  scheduleId: any;
  staffPosition: StaffPosition;
  staff: Staff;
  healthLab: HealthLab;
  date: Date;
}
export class StaffPosition{
  staffPositId: any;
  staffPositName: string;
}

