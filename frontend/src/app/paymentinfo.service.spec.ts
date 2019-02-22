import { TestBed, inject } from '@angular/core/testing';

import { PaymentinfoService } from './paymentinfo.service';

describe('PaymentInfoService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PaymentinfoService]
    });
  });

  it('should be created', inject([PaymentinfoService], (service: PaymentinfoService) => {
    expect(service).toBeTruthy();
  }));
});
