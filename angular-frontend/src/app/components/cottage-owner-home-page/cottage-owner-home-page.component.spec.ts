import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CottageOwnerHomePageComponent } from './cottage-owner-home-page.component';

describe('CottageOwnerHomePageComponent', () => {
  let component: CottageOwnerHomePageComponent;
  let fixture: ComponentFixture<CottageOwnerHomePageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CottageOwnerHomePageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CottageOwnerHomePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
