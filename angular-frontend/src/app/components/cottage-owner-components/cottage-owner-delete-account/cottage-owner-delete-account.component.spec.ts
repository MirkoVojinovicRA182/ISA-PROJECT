import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CottageOwnerDeleteAccountComponent } from './cottage-owner-delete-account.component';

describe('CottageOwnerDeleteAccountComponent', () => {
  let component: CottageOwnerDeleteAccountComponent;
  let fixture: ComponentFixture<CottageOwnerDeleteAccountComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CottageOwnerDeleteAccountComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CottageOwnerDeleteAccountComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
