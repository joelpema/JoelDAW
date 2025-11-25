import { Component, inject } from '@angular/core';
import {CarritoService} from '../../service/carrito-service';
import {ProductoInterface} from '../../interface/producto-interface';
import { ComponentsCard } from "../components-card/components-card";


@Component({
  selector: 'app-components-list',
  imports: [ComponentsCard],
  templateUrl: './components-list.html',
  styleUrl: './components-list.css',
})
export class ComponentsList {

  
  producto : ProductoInterface;

  arrayProductos : ProductoInterface [];

  
  servicioProd = inject(CarritoService);

  

  constructor(){

    this.producto = {
      sku : '',
      title : '',
      price : ''
    }

    this.arrayProductos = []
    
  }

  ngOnInit() : void {
    this.arrayProductos = this.servicioProd.getListadoProductos();

  }



}
