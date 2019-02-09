import { TestBed, inject } from '@angular/core/testing';

import { WorkScheduleRegService } from './workSchedule-reg.service';

describe('WorkScheduleRegService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [WorkScheduleRegService]
    });
  });

  it('should be created', inject([WorkScheduleRegService], (service: WorkScheduleRegService) => {
    expect(service).toBeTruthy();
  }));
});
