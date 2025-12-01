import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ComponentFooter } from './component-footer';

describe('ComponentFooter', () => {
  let component: ComponentFooter;
  let fixture: ComponentFixture<ComponentFooter>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ComponentFooter]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ComponentFooter);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
