import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InstructorOneLessonComponent } from './instructor-one-lesson.component';

describe('InstructorOneLessonComponent', () => {
  let component: InstructorOneLessonComponent;
  let fixture: ComponentFixture<InstructorOneLessonComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InstructorOneLessonComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InstructorOneLessonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
