import { TestBed } from '@angular/core/testing';

import { InstructorLessonsService } from './instructor-lessons.service';

describe('InstructorLessonsService', () => {
  let service: InstructorLessonsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(InstructorLessonsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
