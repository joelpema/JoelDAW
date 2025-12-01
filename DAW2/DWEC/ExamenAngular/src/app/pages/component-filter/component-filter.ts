import { Component, EventEmitter, inject, Output } from '@angular/core';
import { ServiceProducts } from '../../service/service-products';
import { FormsModule } from '@angular/forms';
import { ComponentCard } from "../../components/component-card/component-card";
import { Iproducts } from '../../interfaces/iproducts.interface';

@Component({
  selector: 'app-component-filter',
  imports: [FormsModule],
  templateUrl: './component-filter.html',
  styleUrl: './component-filter.css',
})
export class ComponentFilter {

  filterForm: any;
  productsService = inject(ServiceProducts);
  categorias: string[];
  productArr: Iproducts[];


  @Output() categoriaSelecionada: EventEmitter<string> = new EventEmitter();

  constructor(){
    this.categorias = [];
    this.productArr = [];
  }

  ngOnInit(){
    this.categorias = this.productsService.getAllCategory();
  }
  

  getDataFilter(form: any){
    this.categoriaSelecionada.emit(form.value.categoria);
  }

  


}
