import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TreatComponent } from './treat.component';

describe('TreatComponent', () => {
  let component: TreatComponent;
  let fixture: ComponentFixture<TreatComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TreatComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TreatComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
