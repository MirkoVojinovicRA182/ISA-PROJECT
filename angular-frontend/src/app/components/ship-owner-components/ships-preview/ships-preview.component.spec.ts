import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShipsPreviewComponent } from './ships-preview.component';

describe('ShipsPreviewComponent', () => {
  let component: ShipsPreviewComponent;
  let fixture: ComponentFixture<ShipsPreviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShipsPreviewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ShipsPreviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
