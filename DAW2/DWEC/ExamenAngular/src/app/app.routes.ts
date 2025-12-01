import { Routes } from '@angular/router';
import { ComponentHome } from './pages/component-home/component-home';
import { ComponentList } from './pages/component-list/component-list';
import { ComponentForm } from './pages/component-form/component-form';
import { ComponentFilter } from './pages/component-filter/component-filter';

export const routes: Routes = [

    { path: '', pathMatch: 'full', redirectTo: 'home' },
    { path: 'home', component: ComponentHome },
    { path: 'productos', component: ComponentList },
    { path: 'nuevoProducto', component: ComponentForm },
    { path: 'producto/:id', component: ComponentForm },
    { path: '**', redirectTo: 'home' },


];
