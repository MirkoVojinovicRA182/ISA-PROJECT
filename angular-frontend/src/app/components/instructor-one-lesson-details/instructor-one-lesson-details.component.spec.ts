import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InstructorOneLessonDetailsComponent } from './instructor-one-lesson-details.component';

describe('InstructorOneLessonDetailsComponent', () => {
  let component: InstructorOneLessonDetailsComponent;
  let fixture: ComponentFixture<InstructorOneLessonDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InstructorOneLessonDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InstructorOneLessonDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
