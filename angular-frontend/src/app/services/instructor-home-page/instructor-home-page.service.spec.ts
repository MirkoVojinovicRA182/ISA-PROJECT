import { TestBed } from '@angular/core/testing';

import { InstructorHomePageService } from './instructor-home-page.service';

describe('InstructorHomePageService', () => {
  let service: InstructorHomePageService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(InstructorHomePageService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
