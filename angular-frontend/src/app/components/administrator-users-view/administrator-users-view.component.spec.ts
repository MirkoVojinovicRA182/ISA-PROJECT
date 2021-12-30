import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdministratorUsersViewComponent } from './administrator-users-view.component';

describe('AdministratorUsersViewComponent', () => {
  let component: AdministratorUsersViewComponent;
  let fixture: ComponentFixture<AdministratorUsersViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdministratorUsersViewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdministratorUsersViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
