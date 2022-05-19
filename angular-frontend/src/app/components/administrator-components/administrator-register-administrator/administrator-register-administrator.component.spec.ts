import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdministratorRegisterAdministratorComponent } from './administrator-register-administrator.component';

describe('AdministratorRegisterAdministratorComponent', () => {
  let component: AdministratorRegisterAdministratorComponent;
  let fixture: ComponentFixture<AdministratorRegisterAdministratorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdministratorRegisterAdministratorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdministratorRegisterAdministratorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
