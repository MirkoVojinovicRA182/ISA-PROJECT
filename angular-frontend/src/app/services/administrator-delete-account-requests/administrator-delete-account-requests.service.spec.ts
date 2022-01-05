import { TestBed } from '@angular/core/testing';

import { AdministratorDeleteAccountRequestsService } from './administrator-delete-account-requests.service';

describe('AdministratorDeleteAccountRequestsService', () => {
  let service: AdministratorDeleteAccountRequestsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AdministratorDeleteAccountRequestsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
