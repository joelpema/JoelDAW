import { Component } from '@angular/core';

@Component({
  selector: 'app-primer-component',
  imports: [],
  templateUrl: './primer-component.html',
  styleUrl: './primer-component.css',
})
export class PrimerComponent {

  nombre: string;
  apellidos: string;
  edad: number;
  colorBackGround: string;
  isImportant = false;
  texto: string;

  constructor(){
    this.nombre = "";
    this.apellidos = "";
    this.edad = 0;
    this.colorBackGround = "azul";
    this.isImportant = true;
    this.texto = "hola";
    
  }

  cargarNombre(event : any):void {
    this.nombre = event.target.value;
  }
  cargarApellido(event : any):void {
    this.apellidos = event.target.value;
  }
  cargarEdad(event : any):void {
    this.edad = event.target.value;
  }

  getNombreCompleto(): string {
    return this.nombre + ' ' + this.apellidos;
    //`${this.nombre} ${this.apellidos}`;
  }

  cargarTexto(event : any):void {
    this.texto = event.target.value;
  }

}
