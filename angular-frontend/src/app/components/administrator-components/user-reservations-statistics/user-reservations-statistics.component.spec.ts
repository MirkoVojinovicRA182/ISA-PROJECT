import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserReservationsStatisticsComponent } from './user-reservations-statistics.component';

describe('UserReservationsStatisticsComponent', () => {
  let component: UserReservationsStatisticsComponent;
  let fixture: ComponentFixture<UserReservationsStatisticsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserReservationsStatisticsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UserReservationsStatisticsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
