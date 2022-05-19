import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdministratorCottagesViewComponent } from './administrator-cottages-view.component';

describe('AdministratorCottagesViewComponent', () => {
  let component: AdministratorCottagesViewComponent;
  let fixture: ComponentFixture<AdministratorCottagesViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdministratorCottagesViewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdministratorCottagesViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
