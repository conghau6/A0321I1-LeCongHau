import { TestBed } from '@angular/core/testing';

import { XeService } from './xe.service';

describe('XeService', () => {
  let service: XeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(XeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
