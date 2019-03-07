import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class SuggestionService {
  public API = '//localhost:8080';
  guided: Suggestion = new Suggestion();

  constructor(
    private http: HttpClient
  ) { }


  getPersonnel(): Observable<any>{
    return this.http.get(this.API + '/Personnel');
  }
  getHealthPrograms(): Observable<any>{
    return this.http.get(this.API + '/Health-Program');
  }
  getRequestSuggestions(): Observable<any>{
    return this.http.get(this.API + '/Request-Suggestion');
  }
  getAllDirection(): Observable<any>{
    return this.http.get(this.API + '/Suggestion');
  }
  newPersonnel(personnel: Personnel): Observable<any>{
    return this.http.post(this.API + '/Personnel', personnel);
  }

  direction(program: HealthProgram, personnel: Personnel, request: RequestSuggestion): Observable<any>{
    this.guided = new Suggestion();
    this.guided.personnel = personnel;
    this.guided.requestSuggestion = request;
    this.guided.healthProgram = program;
    return this.http.post(this.API + '/Direction', this.guided);
  }
}

export class Personnel{
  personnelId: any;
  personnelName: string;
  labPersonnelId: string;
  guidanced: string;
}
export class HealthProgram{
  programId: any;
  programName: string;
  price: string;
}
export class Suggestion{
  suggestionId: any;
  requestSuggestion: RequestSuggestion;
  personnel: Personnel;
  healthProgram: HealthProgram;
  date: Date;
}
export class RequestSuggestion{
  requestSuggestionId: any;
  userRequestName: string;
  email: string;
  question: string;
}

