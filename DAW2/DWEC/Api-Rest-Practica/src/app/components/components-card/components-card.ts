import { Component, inject, Input} from '@angular/core';
import { Service } from '../../service/service';
import { Router } from '@angular/router';
import { Iresult } from '../../interfaces/iresult.interface';

@Component({
  selector: 'app-components-card',
  imports: [],
  templateUrl: './components-card.html',
  styleUrl: './components-card.css',
})
export class ComponentsCard {

  serviceUsers = inject(Service);
  router = inject(Router);
  @Input() miUser!: Iresult;


}
