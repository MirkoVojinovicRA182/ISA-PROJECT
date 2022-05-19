import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InstructorReportDialogComponent } from './instructor-report-dialog.component';

describe('InstructorReportDialogComponent', () => {
  let component: InstructorReportDialogComponent;
  let fixture: ComponentFixture<InstructorReportDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InstructorReportDialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InstructorReportDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
