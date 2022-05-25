import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CottageOwnerDefaultComponent } from './cottage-owner-default.component';

describe('CottageOwnerDefaultComponent', () => {
  let component: CottageOwnerDefaultComponent;
  let fixture: ComponentFixture<CottageOwnerDefaultComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CottageOwnerDefaultComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CottageOwnerDefaultComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
