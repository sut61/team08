import { TestBed, inject } from '@angular/core/testing';

import { LogingService } from './loging.service';

describe('LogingService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [LogingService]
    });
  });

  it('should be created', inject([LogingService], (service: LogingService) => {
    expect(service).toBeTruthy();
  }));
});
