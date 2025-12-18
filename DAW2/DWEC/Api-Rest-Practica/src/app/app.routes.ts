
import { Routes } from '@angular/router';
import { ComponentsHome } from './pages/components-home/components-home';
import { ComponentsList } from './pages/components-list/components-list';


export const routes: Routes = [
    { path: '', pathMatch: 'full', redirectTo: 'home' },
    { path: 'home', component: ComponentsHome },
    { path: 'usuarios', component: ComponentsList },
    { path: '**', redirectTo: 'home' }
];
