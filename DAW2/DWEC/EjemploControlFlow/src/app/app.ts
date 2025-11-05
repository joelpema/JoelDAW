import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ControlFlowIf } from "./components/control-flow-if/control-flow-if";
import { SwitchControlFlows } from "./components/switch-control-flows/switch-control-flows";
import { ForControlFlow } from "./components/for-control-flow/for-control-flow";

@Component({
  selector: 'app-root',
  imports: [ControlFlowIf, SwitchControlFlows, ForControlFlow],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('EjemploControlFlow');
  ejemploActivo: string;

  constructor(){
    this.ejemploActivo = "for";
  }
}
