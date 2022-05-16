import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CottagesPreviewComponent } from './cottages-preview.component';

describe('CottagesPreviewComponent', () => {
  let component: CottagesPreviewComponent;
  let fixture: ComponentFixture<CottagesPreviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CottagesPreviewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CottagesPreviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
