import { Injectable } from '@angular/core';
import { NoticiaInterface } from '../interface/noticia-interface';

@Injectable({
  providedIn: 'root',
})
export class NoticiasService {
  
  private arrayNoticias: NoticiaInterface[];

    constructor() {
        this.arrayNoticias = [{
      title: "Alcaraz presume de revés para comenzar las ATP Finals con victoria ante De Miñaur",
      image: 'https://fotografias-2.larazon.es/clipping/cmsimages02/2025/11/09/22C83F8B-7A9E-4963-98C2-5689D34973A6/98.jpg?crop=6176,3475,x0,y322&width=1900&height=1069&optimize=low&format=webply',
      text: "Carlos Alcaraz tuvo un momento de duda en el primer set de su debut en las ATP Finals ante Álex de Miñaur (ganó el español por 7-6 [7/5] y 6-2). En un rato, pasó de mandar 4-1 y 0-40, tres pelotas para doble break, a verse 4-4; y poco después, en el tie-break, perdía 4-5, con dos saques del australiano para cerrar el parcial. De Miñaur no logró jugar ninguno de los dos puntos con primer servicio, y el español apretó sin dudar para dar la vuelta a la situación.",
      fecha: new Date(2025, 10, 9)
    },
    {
      title: "El Real Madrid clama contra el arbitraje en Vallecas por los agarrones a Bellingham y Mbappé",
      image: 'https://objetos-xlk.estaticos-marca.com/files/article_660_widen_webp/uploads/2025/11/09/6910de8240c2f.webp',
      text: "La indignación en el Real Madrid tras el 0-0 en Vallecas es absoluta. El club blanco considera que el arbitraje de Martínez Munuera condicionó un partido ya de por sí gris de los de Xabi Alonso, marcado a su juicio por dos acciones determinantes dentro del área del Rayo. Un agarrón de Chavarría a Bellingham en la primera parte y otro del mismo defensa del Rayo a Mbappé en la segunda, en el tramo final del encuentro. Ambas jugadas, a juicio del Madrid, eran susceptibles de penalti y, en consecuencia, de revisión en VAR. Sin embargo, ni el colegiado sobre el césped ni la sala VOR —dirigida por Figueroa Vázquez— intervinieron.",
      fecha: new Date(2025, 10, 9)
    }];
    }

    getAllNoticias(): NoticiaInterface[] {
        return this.arrayNoticias;
    }

    insertNoticia(worker: NoticiaInterface) {
        this.arrayNoticias.push(worker);
    }


}
