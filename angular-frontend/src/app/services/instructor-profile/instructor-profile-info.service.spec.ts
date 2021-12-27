import { TestBed } from '@angular/core/testing';
import { InstructorProfileInfoService } from './instructor-profile-info.service';


describe('InstructorProfileInfoService', () => {
  let service: InstructorProfileInfoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(InstructorProfileInfoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
