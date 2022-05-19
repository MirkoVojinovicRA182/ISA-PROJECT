import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdministratorShipsViewComponent } from './administrator-ships-view.component';

describe('AdministratorShipsViewComponent', () => {
  let component: AdministratorShipsViewComponent;
  let fixture: ComponentFixture<AdministratorShipsViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdministratorShipsViewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdministratorShipsViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
