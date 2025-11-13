import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CarritoController } from "./controller/carrito-controller/carrito-controller";

@Component({
  selector: 'app-root',
  imports: [CarritoController],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('CarritoEnAngular');
}
