import { Component, inject } from '@angular/core';
import {CarritoService} from './../../service/carrito-service';

@Component({
  selector: 'app-components-carrito',
  imports: [],
  templateUrl: './components-carrito.html',
  styleUrl: './components-carrito.css',
})
export class ComponentsCarrito {

  
  carritoCompra : any[];

  sCarrito = inject (CarritoService);

  producto : any;

  currency : string;

  precioTotal : string;

  

  constructor(){
    this.carritoCompra = [];

    this.producto = {
      sku : '',
      title : '',
      price : '',
      quantity : 0
    }

    this.currency = '';

    this.precioTotal = '';
  }

  ngOnInit() : void{

    this.carritoCompra = this.sCarrito.getCarritoProducts();

    this.currency = this.sCarrito.getCurrency();

    this.precioTotal = this.sCarrito.getPrecioTotal();

  }

  deleteCart() {
    this.sCarrito.eliminarCompra();
  }



}
