import { Component, inject, Input } from '@angular/core';
import { ServiceProducts } from '../../service/service-products';
import { Router } from '@angular/router';
import { Iproducts } from '../../interface/iproducts';

@Component({
  selector: 'app-products-card',
  imports: [],
  templateUrl: './products-card.html',
  styleUrl: './products-card.css',
})
export class ProductsCard {

  productService = inject(ServiceProducts);
  router = inject(Router);
  @Input() miProduct!: Iproducts;

  deleteSerie(producto: Iproducts) {
        this.productService.deleteByTitle(producto.name);
    }

    seeDetails(producto: Iproducts) {
        this.productService.navigate(['/serie', producto.id]);

    }

}
