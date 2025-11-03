import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { GaleriaComponents } from './components/galeria-components/galeria-components';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, GaleriaComponents],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('GaleriaApp');
}
