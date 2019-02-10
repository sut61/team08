import { Component, OnInit } from '@angular/core';
import { SuggestionService, HealthProgram, Personnel, RequestSuggestion, Suggestion} from '../../shared/suggestion/suggestion.service';
import 'rxjs/add/observable/of';
@Component({
  selector: 'app-suggestion',
  templateUrl: './suggestion.component.html',
  styleUrls: ['./suggestion.component.css']
})
export class SuggestionComponent implements OnInit {
  programs: HealthProgram[];
  programSelected = [];
  requests: RequestSuggestion[];
  requestSelected: RequestSuggestion;
  directioned: Suggestion[];
  checkSelected = false;
  infoActivitiess = ["ตรวจเม็ดเลือดเดือนนี้จากราคา 250- เหลือ 200-", "ตรวจโรคติดต่อพร้อมเอ็กซเรย์ปอด ลดเหลือ 900-"];
  personnel: Personnel = new Personnel();
  suggestions: Suggestion[];
  uiTable: string[] = ['userRequestName','email','request','guidanced','program','infoActivities'];



  constructor(
    private service: SuggestionService
  ) { 
    // this.personnel.personnel
  }

  ngOnInit() {
    this.service.getRequestSuggestions().subscribe((request) => {
      this.requests = request;
      // console.log(this.requests);
    });
    this.service.getHealthPrograms().subscribe((program) => {
      this.programs = program;
    });
    this.service.getAllDirection().subscribe((guide) => {
      this.directioned = guide;
    });
    this.service.getAllDirection().subscribe((personnel) => {
      this.suggestions = personnel;
      console.log(this.suggestions);
    });
  }

  selected(event, program: HealthProgram){
    // console.log(event.checked);
    if(event.checked == true){
      this.programSelected.push(program);
    }else{
      let index = this.programSelected.indexOf(program);
      // console.log(index);
     this.programSelected.splice(index, 1);
    }
    // console.log(this.programSelected);

    if(this.programSelected.length > 0){
      this.checkSelected = true;
    }else{
      this.checkSelected = false;
    }
  }

  direction(){
    this.service.newPersonnel(this.personnel).subscribe((resp) => {
      let len = this.programSelected.length;
      for(let i = 0; i < this.programSelected.length; i++){
        this.service.direction(this.programSelected[i], resp, this.requestSelected).subscribe((res) => {
          this.getRepeat();
          console.log(res);
        });
      }
    });
  }
  getRepeat(){
    this.service.getAllDirection().subscribe((personnel) => {
      this.suggestions = personnel;
      console.log(this.suggestions);
      alert('ตอบกลับสำเร็จ');
    });
  }

//  alert(){
//    alert("ตอบกลับสำเร็จ");
//  }
}
