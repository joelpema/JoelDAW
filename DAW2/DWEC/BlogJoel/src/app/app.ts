import { Component, signal } from '@angular/core';

import { NoticesComponents } from "./components/notices-components/notices-components";


@Component({
  selector: 'app-root',
  imports: [NoticesComponents],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('BlogJoel');
}
