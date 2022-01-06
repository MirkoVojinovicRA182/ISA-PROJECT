import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InstructorLessonReservationsViewComponent } from './instructor-lesson-reservations-view.component';

describe('InstructorLessonReservationsViewComponent', () => {
  let component: InstructorLessonReservationsViewComponent;
  let fixture: ComponentFixture<InstructorLessonReservationsViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InstructorLessonReservationsViewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InstructorLessonReservationsViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
