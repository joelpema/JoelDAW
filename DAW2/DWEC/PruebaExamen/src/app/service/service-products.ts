import { Injectable } from '@angular/core';
import { Iproducts } from '../interface/iproducts';

@Injectable({
  providedIn: 'root',
})
export class ServiceProducts {

  
  private arrProd: Iproducts[];
  private id: number;

  constructor(){
    this.arrProd = [];
    this.id = 17;

    fetch("http://localhost:8080/api/products")
            .then(response => response.json())
            .then(datos => {
                datos.forEach((element: any) => {
                    let producto = element as Iproducts;
                    this.arrProd.push(producto);
                });
            });
  }

  getAllProducts(): Iproducts[]{
    return this.arrProd;
  }

  getProductById(id: number): Iproducts | undefined{
    return this.arrProd.find(s => s.id === id);
  }


  navigate(arg0: (string | number)[]) {

    

  }
  deleteByTitle(name: string): void {

      let i = this.arrProd.findIndex(product => product.name == name);
        if (i != -1 && i >= 0 && i < this.arrProd.length) {
            this.arrProd.splice(i, 1);
        }

  }



}
