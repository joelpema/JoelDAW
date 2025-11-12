import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { PrimerComponent } from './Components/primer-component/primer-component';

@Component({
  selector: 'app-root',
  imports: [PrimerComponent, RouterOutlet],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('ejemploAngular');
}
