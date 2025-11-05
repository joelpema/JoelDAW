import { Component } from '@angular/core';

@Component({
  selector: 'app-switch-control-flows',
  imports: [],
  templateUrl: './switch-control-flows.html',
  styleUrl: './switch-control-flows.css',
})
export class SwitchControlFlows {

  roles: string[];
  role: string;

  constructor(){
    this.roles = ["admin","editor","suscriptor","otros"];
    this.role = this.roles[2];
  }
}
