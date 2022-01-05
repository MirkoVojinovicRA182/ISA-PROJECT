import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdministratorDeleteAccountRequestsViewComponent } from './administrator-delete-account-requests-view.component';

describe('AdministratorDeleteAccountRequestsViewComponent', () => {
  let component: AdministratorDeleteAccountRequestsViewComponent;
  let fixture: ComponentFixture<AdministratorDeleteAccountRequestsViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdministratorDeleteAccountRequestsViewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdministratorDeleteAccountRequestsViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
