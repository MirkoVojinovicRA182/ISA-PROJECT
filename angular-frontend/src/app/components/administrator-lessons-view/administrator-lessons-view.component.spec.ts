import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdministratorLessonsViewComponent } from './administrator-lessons-view.component';

describe('AdministratorLessonsViewComponent', () => {
  let component: AdministratorLessonsViewComponent;
  let fixture: ComponentFixture<AdministratorLessonsViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdministratorLessonsViewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdministratorLessonsViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
