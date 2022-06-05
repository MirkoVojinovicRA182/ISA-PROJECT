import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientShipComponent } from './client-ship.component';

describe('ClientShipComponent', () => {
  let component: ClientShipComponent;
  let fixture: ComponentFixture<ClientShipComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ClientShipComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ClientShipComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
