import { Component, OnInit } from '@angular/core';
import { NotificationService } from 'src/app/shared/notification/notification.service'
import { Subscription } from 'rxjs';
import { WorkScheduleRegService, HealthLab, Staff, StaffPosition, WorkSchedule, Workday, Worktime} from '../../shared/workSchedule-reg/workSchedule-reg.service';
import 'rxjs/add/observable/of';
@Component({
  selector: 'app-workSchedule-reg',
  templateUrl: './workSchedule-reg.component.html',
  styleUrls: ['./workSchedule-reg.component.css']
})
export class WorkScheduleRegComponent implements OnInit {
  labs: HealthLab[];
  labSelected = [];
  staffPositions: StaffPosition[];
  staffPositionSelected: StaffPosition;
  workdays: Workday[];
  workdaySelected: Workday;
  worktimes: Worktime[];
  worktimeSelected: Worktime;
  registered: WorkSchedule[];
  checkSelected = false;
  staff: Staff = new Staff(); 
  workSchedules: WorkSchedule[];
  uiTable: string[] = ['name','labStaffID','telNumber','workday','worktime','staffPosition','lab'];



  constructor(
    private service: WorkScheduleRegService,
    public notificaion: NotificationService
  ) { 
    // this.staff.staf
  }

  ngOnInit() {
    this.service.getStaffPositions().subscribe((staffPosition) => {
      this.staffPositions = staffPosition;
      // console.log(this.staffPositions);
    });
    this.service.getWorkdays().subscribe((workday) => {
      this.workdays = workday;
      // console.log(this.days);
    });
    this.service.getWorktimes().subscribe((worktime) => {
      this.worktimes = worktime;
    });
    this.service.getHealthLabs().subscribe((lab) => {
      this.labs = lab;
    });
    this.service.getAllRegister().subscribe((reg) => {
      this.registered = reg;
    }, err => {
      console.log(err);
    }

    );
    this.service.getAllRegister().subscribe((staff) => {
      this.workSchedules = staff;
      console.log(this.workSchedules);
    });
  }

  selected(event, lab: HealthLab){
    // console.log(event.checked);
    if(event.checked == true){
      this.labSelected.push(lab);
    }else{
      let index = this.labSelected.indexOf(lab);
      // console.log(index);
     this.labSelected.splice(index, 1);
    }
    // console.log(this.labSelected);

    if(this.labSelected.length > 0){
      this.checkSelected = true;
    }else{
      this.checkSelected = false;
    }
  }

  register(){
    this.service.newStaff(this.staff).subscribe((resp) => {
      let len = this.labSelected.length;
      for(let i = 0; i < this.labSelected.length; i++){
        this.service.register(this.labSelected[i], resp, this.staffPositionSelected, this.workdaySelected, this.worktimeSelected).subscribe((res) => {
          this.getRepeat();
          console.log(res);
        });
      }
    }, err => {
        this.notificaion.error();
        console.log(err);
       }

    );
  }
  getRepeat(){
    this.service.getAllRegister().subscribe((staff) => {
      this.workSchedules = staff;
      console.log(this.workSchedules);
          alert("บันทึกสำเร็จ");
    });
  }

//  alert(){
//    alert("บันทึกสำเร็จ");
//  }
}

