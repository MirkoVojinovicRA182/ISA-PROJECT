import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InstructorClientInfoDialogComponent } from './instructor-client-info-dialog.component';

describe('InstructorClientInfoDialogComponent', () => {
  let component: InstructorClientInfoDialogComponent;
  let fixture: ComponentFixture<InstructorClientInfoDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InstructorClientInfoDialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InstructorClientInfoDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
