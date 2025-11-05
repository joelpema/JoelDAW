import { Component } from '@angular/core';

@Component({
  selector: 'app-for-control-flow',
  imports: [],
  templateUrl: './for-control-flow.html',
  styleUrl: './for-control-flow.css',
})
export class ForControlFlow {


  estudiantes: any[];
  nElementos:number;

  constructor(){
    this.estudiantes = [
      {id: 1, name: "Frodo Bolson", age: 23},
      {id: 2, name: "Frodo Bolson", age: 83},
      {id: 3, name: "Frodo Bolson", age: 23},
      {id: 4, name: "Frodo Bolson", age: 23},
      {id: 5, name: "Frodo Bolson", age: 23}
    ];
    this.nElementos = this.estudiantes.length;
  }


  insertarEstudiante() : void {
    this.estudiantes.push({id: this.nElementos+1, name: "Boromir", age: 35})
    this.nElementos = this.estudiantes.length;
  }

}
