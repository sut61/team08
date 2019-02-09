import { Component, OnInit } from '@angular/core';
import { WorkScheduleRegService, HealthLab, Staff, StaffPosition, WorkSchedule} from '../../shared/workSchedule-reg/workSchedule-reg.service';
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
  registered: WorkSchedule[];
  checkSelected = false;
  dayWorks = ["จันทร์", "อังคาร", "พุธ", "พฤหัสบดี", "ศุกร์", "เสาร์", "อาทิตย์"];
  workTimes = ["08.00-15.00 น.", "09.00-16.00 น.", "10.00-17.00 น.", "11.00-18.00 น.", "12.00-19.00 น.", "13.00-20.00 น."];
  staff: Staff = new Staff(); 
  workSchedules: WorkSchedule[];
  uiTable: string[] = ['name','labStaffID','telNumber','dayWork','workTime','staffPosition','lab'];



  constructor(
    private service: WorkScheduleRegService
  ) { 
    // this.staff.staf
  }

  ngOnInit() {
    this.service.getStaffPositions().subscribe((staffPosition) => {
      this.staffPositions = staffPosition;
      // console.log(this.staffPositions);
    });
    this.service.getHealthLabs().subscribe((lab) => {
      this.labs = lab;
    });
    this.service.getAllRegister().subscribe((reg) => {
      this.registered = reg;
    });
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
        this.service.register(this.labSelected[i], resp, this.staffPositionSelected).subscribe((res) => {
          this.getRepeat();
          console.log(res);
        });
      }
    });
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

