import { Component, signal, inject} from '@angular/core';
import {ComponentsList} from "./components/components-list/components-list";
import {CarritoService} from './service/carrito-service';
import {ComponentsCarrito} from './components/components-carrito/components-carrito';
import { FormsModule } from '@angular/forms';
import { ComponentsCard } from './components/components-card/components-card';


@Component({
  selector: 'app-root',
  imports: [ComponentsCarrito, ComponentsList],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  
  protected readonly title = signal('angularCarrito');


  carritoProductos : any[];

  
  servicioProd = inject(CarritoService);

  producto : any;

  range! : number;

  constructor() {
    this.carritoProductos = [];

    this.producto = {
      sku : '',
      title : '',
      price : '',
      quantity : ''
    };
  }

  ngOnInit(): void {
    this.carritoProductos = this.servicioProd.getCarritoProducts();
  }

  filtrarPorPrecio(rango : any) {
    this.servicioProd.filtrarListaPrecio(rango);
  }

}
