import { Injectable } from '@angular/core';
import { CarritoInterface } from '../initenrface/carrito-interface';


@Injectable({
  providedIn: 'root',
})
export class CarritoService {
  

  arrayProductos: CarritoInterface[];
  currency: string;

  constructor(){

    this.arrayProductos = [];
    this.currency = "€";

  fetch('http://localhost:8080/api/carrito')
        .then(response => {
            if (!response.ok) {
                throw new Error('Error al cargar el JSON');
            }
            return response.json();
        })
        .then(data => {
            this.arrayProductos =data.arrayProductos;
          })
        .catch(error => console.error(error));

  }

  ObtenerProductos(): CarritoInterface[]{
    return this.arrayProductos;
  }

  console.log(arrayProductos);
}