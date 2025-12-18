import { Service } from '../../service/service';
import { Component, inject } from '@angular/core';
import { ComponentsCard } from "../../components/components-card/components-card";
import { Iresult } from '../../interfaces/iresult.interface';

@Component({
  selector: 'app-components-list',
  imports: [ComponentsCard],
  templateUrl: './components-list.html',
  styleUrl: './components-list.css',
})
export class ComponentsList {

  UserArr : Iresult[];
  usersService = inject(Service);

  constructor(){
    this.UserArr = [];
  }

  async ngOnInit(): Promise<void> {
    try{
      this.UserArr = await this.usersService.getAllUsersWithPromise();
    }
    catch(err){
      console.log("Error al conectar a la API")
      alert('Error al conectar a la API')
    }
  }

}
