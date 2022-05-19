import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InstructorOneLessonDetailComponent } from './instructor-one-lesson-detail.component';

describe('InstructorOneLessonDetailComponent', () => {
  let component: InstructorOneLessonDetailComponent;
  let fixture: ComponentFixture<InstructorOneLessonDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InstructorOneLessonDetailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InstructorOneLessonDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
