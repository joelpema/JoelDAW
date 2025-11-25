import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ComponentsCard } from './components-card';

describe('ComponentsCard', () => {
  let component: ComponentsCard;
  let fixture: ComponentFixture<ComponentsCard>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ComponentsCard]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ComponentsCard);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
