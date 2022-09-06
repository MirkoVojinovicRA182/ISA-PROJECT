import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShipsOwnerHomePageComponent } from './ships-owner-home-page.component';

describe('ShipsOwnerHomePageComponent', () => {
  let component: ShipsOwnerHomePageComponent;
  let fixture: ComponentFixture<ShipsOwnerHomePageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShipsOwnerHomePageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ShipsOwnerHomePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
