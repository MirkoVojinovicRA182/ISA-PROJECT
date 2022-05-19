import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActionAdventureCreateDialogComponent } from './action-adventure-create-dialog.component';

describe('ActionAdventureCreateDialogComponent', () => {
  let component: ActionAdventureCreateDialogComponent;
  let fixture: ComponentFixture<ActionAdventureCreateDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ActionAdventureCreateDialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ActionAdventureCreateDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
