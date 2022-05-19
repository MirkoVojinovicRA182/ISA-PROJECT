import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InstructorAddLessonComponent } from './instructor-add-lesson.component';

describe('InstructorAddLessonComponent', () => {
  let component: InstructorAddLessonComponent;
  let fixture: ComponentFixture<InstructorAddLessonComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InstructorAddLessonComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InstructorAddLessonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
