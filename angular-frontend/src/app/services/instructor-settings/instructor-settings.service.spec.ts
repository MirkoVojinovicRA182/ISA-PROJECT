import { TestBed } from '@angular/core/testing';

import { InstructorSettingsService } from './instructor-settings.service';

describe('InstructorSettingsService', () => {
  let service: InstructorSettingsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(InstructorSettingsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
