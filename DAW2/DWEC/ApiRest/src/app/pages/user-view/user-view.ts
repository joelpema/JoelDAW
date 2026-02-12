import { Iusuario } from './../../interfaces/iusuario';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { UsuarioService } from './../../services/usuario-service';
import { Component, EventEmitter, inject, Output } from '@angular/core';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-user-view',
  imports: [RouterModule],
  templateUrl: './user-view.html',
  styleUrl: './user-view.css',
})
export class UserView {


  @Output() usuarioEliminado = new EventEmitter<string>()

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

  async eliminarUsuario(usuario: Iusuario) {
      const result = await Swal.fire({
        title: '¿Estás seguro?',
        imageUrl: `${usuario.image}`,
        imageWidth: `250`,
        imageHeight: `250`,
        text: `Se eliminará a ${usuario.first_name} ${usuario.last_name}`,
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#d33',
        cancelButtonColor: '#2b85daff',
        confirmButtonText: 'Si, eliminar',
        cancelButtonText: 'Cancelar'
      });
  
      if (result.isConfirmed) {
        this.usuarioEliminado.emit(usuario._id);
      }
    }

}
