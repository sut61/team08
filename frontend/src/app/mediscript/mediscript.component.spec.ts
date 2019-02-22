import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MediscriptComponent } from './mediscript.component';

describe('MediscriptComponent', () => {
  let component: MediscriptComponent;
  let fixture: ComponentFixture<MediscriptComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MediscriptComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MediscriptComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
