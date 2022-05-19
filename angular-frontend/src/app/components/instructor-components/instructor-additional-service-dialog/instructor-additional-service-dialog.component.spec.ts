import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InstructorAdditionalServiceDialogComponent } from './instructor-additional-service-dialog.component';

describe('InstructorAdditionalServiceDialogComponent', () => {
  let component: InstructorAdditionalServiceDialogComponent;
  let fixture: ComponentFixture<InstructorAdditionalServiceDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InstructorAdditionalServiceDialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InstructorAdditionalServiceDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
