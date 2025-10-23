import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PruebaComponents } from './prueba-components';

describe('PruebaComponents', () => {
  let component: PruebaComponents;
  let fixture: ComponentFixture<PruebaComponents>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PruebaComponents]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PruebaComponents);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
