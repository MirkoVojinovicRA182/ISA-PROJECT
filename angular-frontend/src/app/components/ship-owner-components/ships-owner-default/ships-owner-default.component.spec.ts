import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShipsOwnerDefaultComponent } from './ships-owner-default.component';

describe('ShipsOwnerDefaultComponent', () => {
  let component: ShipsOwnerDefaultComponent;
  let fixture: ComponentFixture<ShipsOwnerDefaultComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShipsOwnerDefaultComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ShipsOwnerDefaultComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
