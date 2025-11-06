import { Component, signal } from '@angular/core';
import { BlogComponent } from "./components/blog-component/blog-component";
import { NoticesComponents } from "./components/notices-components/notices-components";
import { NavbarComponents } from "./components/navbar-components/navbar-components";

@Component({
  selector: 'app-root',
  imports: [BlogComponent, NoticesComponents, NavbarComponents],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('BlogJoel');
}
