import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ComponentNavbar } from "./components/component-navbar/component-navbar";
import { ComponentFooter } from "./components/component-footer/component-footer";
import { ProductsList } from "./pages/products-list/products-list";

@Component({
  selector: 'app-root',
  imports: [ComponentNavbar, ComponentFooter, RouterOutlet, ProductsList],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('PruebaExamen');
}
