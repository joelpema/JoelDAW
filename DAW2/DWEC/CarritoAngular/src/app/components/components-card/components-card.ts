import { Component, inject, Input } from '@angular/core';
import {CarritoService} from '../../service/carrito-service';
import {ProductoInterface} from '../../interface/producto-interface';

@Component({
  selector: 'app-components-card',
  imports: [],
  templateUrl: './components-card.html',
  styleUrl: './components-card.css',
})
export class ComponentsCard {

  sCarrito = inject(CarritoService);

  @Input()  producto: ProductoInterface;

  quantity! : number;

  currency! : string;

  constructor() {
    this.producto = {
      sku : '',
      title : '',
      price : ''
    }

  }

  ngOnInit() : void {
    this.currency = this.sCarrito.getCurrency();

    this.quantity = this.sCarrito.getInitialQuantity();
  }

ComprarProducto() {
  this.quantity++;
  let compra = {
    sku: this.producto.sku,
    title: this.producto.title,
    price: Number(this.producto.price),
    quantity: this.quantity
  };

  this.sCarrito.addProductCarrito(compra);
}

VenderProducto() {
  if(this.quantity > 0) {
    this.quantity--;
    
    let venta = {
      sku: this.producto.sku,
      title: this.producto.title,
      price: Number(this.producto.price),
      quantity: this.quantity
    };
    this.sCarrito.removeProductCarrito(venta);
  }
}

}
