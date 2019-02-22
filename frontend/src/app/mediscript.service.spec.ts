import { TestBed, inject } from '@angular/core/testing';

import { MediscriptService } from './mediscript.service';

describe('MediscriptService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [MediscriptService]
    });
  });

  it('should be created', inject([MediscriptService], (service: MediscriptService) => {
    expect(service).toBeTruthy();
  }));
});
