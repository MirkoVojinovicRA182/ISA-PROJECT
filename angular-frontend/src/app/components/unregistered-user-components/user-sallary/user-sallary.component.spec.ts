import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserSallaryComponent } from './user-sallary.component';

describe('UserSallaryComponent', () => {
  let component: UserSallaryComponent;
  let fixture: ComponentFixture<UserSallaryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserSallaryComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UserSallaryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
