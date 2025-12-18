import { Iusuario } from './../../interfaces/iusuario';
import { ActivatedRoute, RouterLink, RouterModule } from '@angular/router';
import { UsuarioService } from './../../services/usuario-service';
import { Component, inject } from '@angular/core';

@Component({
  selector: 'app-user-view',
  imports: [RouterModule, RouterLink],
  templateUrl: './user-view.html',
  styleUrl: './user-view.css',
})
export class UserView {
  usuario !: Iusuario;
SUsuarioService = inject(UsuarioService);
activatedRoute = inject(ActivatedRoute);
  constructor(){}

  ngOnInit(): void{
    this.activatedRoute.params.subscribe(async (params : any) =>{
      let _id: string = params._id;

      if(_id != undefined) {
          let response = await this.SUsuarioService.getByID(_id);
          if (response != undefined) {
            this.usuario = response;
          }
      }
    })

  }
}
