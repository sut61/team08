import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WorkScheduleRegComponent } from './workSchedule-reg.component';

describe('WorkScheduleRegComponent', () => {
  let component: WorkScheduleRegComponent;
  let fixture: ComponentFixture<WorkScheduleRegComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WorkScheduleRegComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WorkScheduleRegComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
