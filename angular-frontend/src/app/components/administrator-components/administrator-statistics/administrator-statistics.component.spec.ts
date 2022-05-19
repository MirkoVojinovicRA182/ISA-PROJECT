import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdministratorStatisticsComponent } from './administrator-statistics.component';

describe('AdministratorStatisticsComponent', () => {
  let component: AdministratorStatisticsComponent;
  let fixture: ComponentFixture<AdministratorStatisticsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdministratorStatisticsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdministratorStatisticsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
