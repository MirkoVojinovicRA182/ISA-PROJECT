import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientCottageComponent } from './client-cottage.component';

describe('ClientCottageComponent', () => {
  let component: ClientCottageComponent;
  let fixture: ComponentFixture<ClientCottageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ClientCottageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ClientCottageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
