import { Injectable } from '@angular/core';
import { ProductoInterface } from '../interface/producto-interface';

@Injectable({
  providedIn: 'root',
})
export class CarritoService {

  producto! : ProductoInterface;

  
  private arrayProductos : ProductoInterface[];

  private carritoProductos : any[];

  private currency! : string;

  private precioTotal : number

  private initialQuantity : number;

  constructor(){

    this.arrayProductos = [];

    fetch('http://localhost:8080/api/carrito')
    .then(response => response.json())
    .then(data => {

        this.currency = data.currency;
        data.products.forEach((product: ProductoInterface)=> {
            this.arrayProductos.push(product);
        });
        
        
    });

    this.carritoProductos = [];
    this.precioTotal = 0;
    this.initialQuantity = 0;
  }


  getListadoProductos () : ProductoInterface[]{
    return this.arrayProductos;
  }

  addProductCarrito (producto : any) : void {

    let indice = this.carritoProductos.findIndex((prod) => prod.sku === producto.sku);

    if(indice !== -1){
      this.carritoProductos[indice].quantity = producto.quantity;
    }else{
      this.carritoProductos.push(producto);
    }
    this.precioTotal += producto.price;
  }

  removeProductCarrito(producto : any) : void {
    let indice = this.carritoProductos.findIndex((prod) => prod.sku === producto.sku);

    if(indice !== -1){
      this.carritoProductos[indice].quantity = producto.quantity;
      if(this.carritoProductos[indice].quantity === 0){
        this.carritoProductos.splice(indice, 1);
      }
      
    }

    this.precioTotal -= producto.price;
  }

  getCurrency() : string {
    return this.currency;
  }

  getCarritoProducts() : any[] {
    return this.carritoProductos;
  }

  getPrecioTotal() : string{
    return this.precioTotal.toFixed(2);
  }

  eliminarCompra() {
    this.carritoProductos.splice(0,this.carritoProductos.length);
    this.precioTotal = 0;
  }

  getInitialQuantity() : number{
    return this.initialQuantity;
  }
  
}
