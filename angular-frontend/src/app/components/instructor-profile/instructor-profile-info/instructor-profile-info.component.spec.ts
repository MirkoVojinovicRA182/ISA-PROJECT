import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InstructorProfileInfoComponent } from './instructor-profile-info.component';

describe('InstructorProfileInfoComponent', () => {
  let component: InstructorProfileInfoComponent;
  let fixture: ComponentFixture<InstructorProfileInfoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InstructorProfileInfoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InstructorProfileInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
