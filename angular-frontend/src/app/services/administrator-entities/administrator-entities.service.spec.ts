import { TestBed } from '@angular/core/testing';

import { AdministratorEntitiesService } from './administrator-entities.service';

describe('AdministratorEntitiesService', () => {
  let service: AdministratorEntitiesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AdministratorEntitiesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
