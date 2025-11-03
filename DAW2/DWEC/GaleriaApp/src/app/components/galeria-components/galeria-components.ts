import { Component } from '@angular/core';
import { ImageInterface } from '../../interfaces/image-interface';

@Component({
  selector: 'app-galeria-components',
  imports: [],
  templateUrl: './galeria-components.html',
  styleUrl: './galeria-components.css',
})
export class GaleriaComponents {

  arrayImagenes : ImageInterface[];
  imagenActual: number;

  constructor(){

    this.imagenActual = 0;
    this.arrayImagenes = [{

      url: 'https://placehold.co/600x400/orange/white',
      title: 'Naranja',
      alt: 'soy un cuadrado naranja'
      },
        {
          url: 'https://placehold.co/600x400/blue/white',
          title: 'Azul'
      },
        {
          url: 'https://placehold.co/600x400/green/white',
          title: 'Verde'
      },
        {
          url: 'https://placehold.co/600x400/red/white',
          title: 'Rojo'
      }]

  }

  anterior() : void {
    this.imagenActual--;
    if(this.imagenActual < 0){
      this.imagenActual = this.arrayImagenes.length -1;
    }
  }

  siguiente() : void {
    this.imagenActual++;
    if(this.imagenActual >= this.arrayImagenes.length){
      this.imagenActual = 0;
    }
  }

}
