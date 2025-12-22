import { Routes } from '@angular/router';
import { Home } from './pages/home/home';
import { UserFormComponent } from './pages/user-form/user-form';
import { UserList } from './pages/user-list/user-list';
import { UserView } from './pages/user-view/user-view';

export const routes: Routes = [
    { path: '', pathMatch: 'full', redirectTo: 'home'},
    { path: 'home', component: Home},
    { path: 'formulario', component: UserFormComponent},
    { path: 'formulario/:_id', component: UserFormComponent},
    { path: 'usuarios', component: UserList},
    { path: 'usuarios/:_id', component: UserView},
    { path: '**', component: Home },
];