
import { Injectable } from '@angular/core';
import { Iproducts } from '../interfaces/iproducts.interface';

@Injectable({
  providedIn: 'root',
})
export class ServiceProducts {
  private arrProd: Iproducts[];
  private id: number;
  private categories: string[];

  constructor(){

    this.arrProd = [];
    this.id = 17;
    this.categories = [];
    this.categories.push('mujer');
    this.categories.push('hombre');
    this.categories.push('niño');

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
  
  getAllCategory(): string [] {
    return this.categories;
  }

  getProductByCategoria(categoria: string): Iproducts[]{
      return this.arrProd.filter(producto => producto.category.includes(categoria));
  }

  deleteByTitle(name: string): void {
      let i = this.arrProd.findIndex(product => product.name == name);
        if (i != -1 && i >= 0 && i < this.arrProd.length) {
            this.arrProd.splice(i, 1);
        }
  
  }

    insertProducto(product: Iproducts) {
      if (!this.arrProd.includes(product) && product != null) {
            product.id = this.id;
            this.arrProd.push(product);
            this.id++;
            console.log(this.id)
        }
  }
    updateProducto(product: Iproducts): void {
      console.log(this.arrProd);
      let i = this.arrProd.findIndex(pr => pr.id == product.id);
      product.id = this.arrProd[i].id;

        if (i != -1 && i >= 0 && i < this.arrProd.length) {
            this.arrProd.splice(i, 1);
        }

        this.arrProd.push(product);

  }
    getProductById(id: number) {
    return this.arrProd.find(p => p.id === id);
  }

}
