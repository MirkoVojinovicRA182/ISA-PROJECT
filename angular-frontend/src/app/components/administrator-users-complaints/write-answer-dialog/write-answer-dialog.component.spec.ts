import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WriteAnswerDialogComponent } from './write-answer-dialog.component';

describe('WriteAnswerDialogComponent', () => {
  let component: WriteAnswerDialogComponent;
  let fixture: ComponentFixture<WriteAnswerDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WriteAnswerDialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(WriteAnswerDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
