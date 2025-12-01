import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ComponentNavBar } from "./components/component-nav-bar/component-nav-bar";
import { ComponentFooter } from "./components/component-footer/component-footer";
import { ComponentList } from "./pages/component-list/component-list";
import { ComponentForm } from "./pages/component-form/component-form";

@Component({
  selector: 'app-root',
  imports: [ComponentNavBar, ComponentFooter, RouterOutlet],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {

}
