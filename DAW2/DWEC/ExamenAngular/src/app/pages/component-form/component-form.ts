import { Component, inject } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ServiceProducts } from '../../service/service-products';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { Iproducts } from '../../interfaces/iproducts.interface';

@Component({
  selector: 'app-component-form',
  imports: [ReactiveFormsModule, RouterLink],
  templateUrl: './component-form.html',
  styleUrl: './component-form.css',
})
export class ComponentForm {


  productForm: FormGroup;
  productoService = inject(ServiceProducts);
  activatedRoute = inject(ActivatedRoute);
  router = inject(Router);

  isNew: boolean;

  constructor(){

    this.isNew = true;
    this.productForm = new FormGroup({
      name: new FormControl(null, [Validators.required]),
      description: new FormControl(null, [Validators.required]),
      price: new FormControl(null, [Validators.required]),
      category: new FormControl(null, [Validators.required]),
      image: new FormControl(null, [Validators.required]),
      active: new FormControl(null, [Validators.required]),
    },[]);


  }


  getDataForm() {
  let product = this.productForm.value as Iproducts;
        if (this.isNew) {
            product.id = -1;
            this.productoService.insertProducto(product);
        }
        else {
            //llamar a update en el servicio
            this.productoService.updateProducto(product);
            console.log(product);
        }

        this.productForm.reset();
        this.router.navigate(['productos'])
  }

  ngOnInit(){
    this.activatedRoute.params.subscribe((params : any) => {
      let id: number = params.id;
      if(id != undefined){

        let miProduct = this.productoService.getProductById(id);
        if(miProduct != undefined){
          this.isNew = false;
          this.productForm = new FormGroup({
            id: new FormControl(miProduct.id, []),
            name: new FormControl(miProduct.name, [Validators.required]),
            description: new FormControl(miProduct.description, [Validators.required]),
            price: new FormControl(miProduct.price, [Validators.required]),
            category: new FormControl(miProduct.category, [Validators.required]),
            image: new FormControl(miProduct.image, [Validators.required]),
            active: new FormControl(miProduct.active, [Validators.required]),
          },[]);
        }else{
          alert("No se encuentra ningun servicio");
        }
      }


    });

  }

}
