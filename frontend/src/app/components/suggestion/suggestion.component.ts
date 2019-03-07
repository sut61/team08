import { Component, OnInit } from '@angular/core';
import { NotificationService } from 'src/app/shared/notification/notification.service'
import { Subscription } from 'rxjs';
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
  personnel: Personnel = new Personnel();
  suggestions: Suggestion[];
  uiTable: string[] = ['userRequestName','email','request','guidanced','program'];



  constructor(
    private service: SuggestionService,
    public notificaion: NotificationService
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
    }, err => {
      console.log(err);
    }

    );
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
    }, err => {
        this.notificaion.error();
        console.log(err);
       }

    );
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

