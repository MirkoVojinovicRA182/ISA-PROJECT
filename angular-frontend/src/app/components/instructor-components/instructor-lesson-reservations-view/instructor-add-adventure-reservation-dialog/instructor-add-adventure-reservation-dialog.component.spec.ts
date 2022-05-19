import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InstructorAddAdventureReservationDialogComponent } from './instructor-add-adventure-reservation-dialog.component';

describe('InstructorAddAdventureReservationDialogComponent', () => {
  let component: InstructorAddAdventureReservationDialogComponent;
  let fixture: ComponentFixture<InstructorAddAdventureReservationDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InstructorAddAdventureReservationDialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InstructorAddAdventureReservationDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
