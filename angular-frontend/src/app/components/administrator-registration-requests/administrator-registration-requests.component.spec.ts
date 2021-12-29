import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdministratorRegistrationRequestsComponent } from './administrator-registration-requests.component';

describe('AdministratorRegistrationRequestsComponent', () => {
  let component: AdministratorRegistrationRequestsComponent;
  let fixture: ComponentFixture<AdministratorRegistrationRequestsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdministratorRegistrationRequestsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdministratorRegistrationRequestsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
