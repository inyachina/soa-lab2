import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateLabPopupComponent } from './create-lab-popup.component';

describe('CreateLabPopupComponent', () => {
  let component: CreateLabPopupComponent;
  let fixture: ComponentFixture<CreateLabPopupComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateLabPopupComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreateLabPopupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
