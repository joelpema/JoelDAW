import { Component } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { IWorker } from '../../interfaces/i-worker.interface';

@Component({
  selector: 'app-form-template-component',
  imports: [FormsModule],
  templateUrl: './form-template-component.html',
  styleUrl: './form-template-component.css',
})
export class FormTemplateComponent {


  getDataForm(miFormulario: NgForm) {
    let trabajador: IWorker = miFormulario.value as IWorker;
    console.log(trabajador);
    miFormulario.reset();
}

}
