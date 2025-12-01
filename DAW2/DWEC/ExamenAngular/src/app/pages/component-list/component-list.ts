import { ServiceProducts } from './../../service/service-products';
import { Component, inject } from '@angular/core';
import { Iproducts } from '../../interfaces/iproducts.interface'; 
import { ComponentCard } from '../../components/component-card/component-card';
import { RouterLink } from '@angular/router';
import { ComponentFilter } from "../component-filter/component-filter";

@Component({
  selector: 'app-component-list',
  imports: [ComponentCard, ComponentFilter],
  templateUrl: './component-list.html',
  styleUrl: './component-list.css',
})
export class ComponentList {

  productArr: Iproducts[];
  productosService = inject(ServiceProducts);

  constructor(){
    this.productArr = []
  }

  ngOnInit(): void{
    this.productArr = this.productosService.getAllProducts();
  }

    getCourse($event: string) {
        this.productArr = this.productosService.getProductByCategoria($event);
    }
}
