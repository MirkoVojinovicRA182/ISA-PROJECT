import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EjectRegistrationRequestComponent } from './eject-registration-request.component';

describe('EjectRegistrationRequestComponent', () => {
  let component: EjectRegistrationRequestComponent;
  let fixture: ComponentFixture<EjectRegistrationRequestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EjectRegistrationRequestComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EjectRegistrationRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
