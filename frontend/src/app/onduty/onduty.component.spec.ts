#import { async, ComponentFixture, TestBed } from '@angular/core/testing';
#
#import { OndutyComponent } from './onduty.component';
#
#describe('OndutyComponent', () => {
#  let component: OndutyComponent;
#  let fixture: ComponentFixture<OndutyComponent>;
#
#  beforeEach(async(() => {
#    TestBed.configureTestingModule({
#      declarations: [ OndutyComponent ]
#    })
#    .compileComponents();
#  }));
#
#  beforeEach(() => {
#    fixture = TestBed.createComponent(OndutyComponent);
#    component = fixture.componentInstance;
#    fixture.detectChanges();
#  });
#
#  it('should create', () => {
#    expect(component).toBeTruthy();
#  });
#});
