import { Component, inject, Input} from '@angular/core';
import { Router} from '@angular/router';
import { ServiceProducts } from '../../service/service-products';
import { Iproducts } from '../../interfaces/iproducts.interface';


@Component({
  selector: 'app-component-card',
  imports: [],
  templateUrl: './component-card.html',
  styleUrl: './component-card.css',
})
export class ComponentCard {

  productService = inject(ServiceProducts);
  router = inject(Router);
  @Input() miProduct!: Iproducts;
  

  deleteProduct(producto: Iproducts) {
  this.productService.deleteByTitle(producto.name)
  }
  seeDetails(producto: Iproducts) {
    this.router.navigate(['/producto', producto.id]);
  }


}
