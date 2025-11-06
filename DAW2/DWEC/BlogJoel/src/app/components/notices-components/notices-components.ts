import { Component } from '@angular/core';
import { NoticiaInterface } from '../../interface/noticia-interface';

@Component({
  selector: 'app-notices-components',
  imports: [],
  templateUrl: './notices-components.html',
  styleUrl: './notices-components.css',
})
export class NoticesComponents {

  arrayNoticias: NoticiaInterface[] = [];
  noticiaActual: number;

  constructor(){
    this.noticiaActual = 0;
    this.arrayNoticias = [{
      title: "La Audiencia Nacional investigará los pagos en metálico del PSOE a Ábalos y Koldo tras la petición del Supremo",
      image: 'https://cadenaser.com/resizer/v2/PBPHCEH7XE6YZU5BDDJZFYBI2Y.jpg?auth=d268c0db51f7975c2507b2872cf733a53ac11cb165bd689aea8c5ee093852a92&quality=70&width=768&height=576&smart=true',
      text: "El juez Ismael Moreno, instructor del caso Koldo en la Audiencia Nacional que investiga el supuesto cobro de comisiones por la venta de mascarillas durante la pandemia en el marco del caso Koldo, ha acordado abrir una pieza separada sobre los pagos en metálico realizados al exministro de Transportes y exsecretario de Organización del PSOE José Luis Ábalos y su asesor ministerial, Koldo García. En una providencia a la que ha tenido acceso RTVE este jueves, el magistrado ha detallado que incluye en la pieza toda la documentación enviada por el magistrado del Tribunal Supremo Leopoldo Puente. El alto tribunal adjuntó en su auto las declaraciones prestadas por al exdirector gerente del PSOE Mariano Moreno Pavón, la empleada del partido Celia Rodríguez, así como la de la empresaria Carmen Pano, que aseguró haber entregado 90.000 euros en metálico en la sede de Ferraz a petición del comisionista del caso Koldo, Víctor de Aldama. Junto a esta información, el TS remitió a Moreno la parte del informe de la Unidad Central Operativa (UCO) de la Guardia Civil en el que se analizan esos pagos en efectivo a Ábalos y a Koldo, que en algunas ocasiones recogía su mujer Patricia Úriz, así como la información facilitada por el PSOE y que vincula dichos pagos a liquidaciones de gastos."
    },
    {
      title: "",
      image: "",
      text: ""
    }
  
  ];

  }

}

