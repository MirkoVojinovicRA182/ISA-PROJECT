import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdministratorUsersComplaintsComponent } from './administrator-users-complaints.component';

describe('AdministratorUsersComplaintsComponent', () => {
  let component: AdministratorUsersComplaintsComponent;
  let fixture: ComponentFixture<AdministratorUsersComplaintsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdministratorUsersComplaintsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdministratorUsersComplaintsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
