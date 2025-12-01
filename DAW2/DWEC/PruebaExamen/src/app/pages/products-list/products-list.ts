import { Component, inject } from '@angular/core';
import { Iproducts } from '../../interface/iproducts';
import { ServiceProducts } from '../../service/service-products';
import { ProductsCard } from "../../components/products-card/products-card";
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-products-list',
  imports: [ProductsCard, RouterLink],
  templateUrl: './products-list.html',
  styleUrl: './products-list.css',
})
export class ProductsList {

  productArr: Iproducts[];
  produstosService = inject(ServiceProducts);

  constructor(){
    this.productArr = [];
  }

  ngOnInit(): void{
    this.productArr = this.produstosService.getAllProducts();
  }

}
