import { Component, inject } from '@angular/core';
import { NoticiaInterface } from '../../interface/noticia-interface';
import { NoticiasService } from '../../service/noticias.service';
import { FormsModule, NgForm } from '@angular/forms';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-notices-components',
  imports: [FormsModule, DatePipe],
  templateUrl: './notices-components.html',
  styleUrl: './notices-components.css',
})
export class NoticesComponents {

  arrayNoticias: NoticiaInterface[];
  noticiasServicios = inject(NoticiasService);

  constructor(){
    this.arrayNoticias = [];

  }

  ngOnInit(): void{
    this.arrayNoticias = this.noticiasServicios.getAllNoticias();
  }

  getDataForm(misNoticias: NgForm){
    let noticia : NoticiaInterface = misNoticias.value as NoticiaInterface;
    console.log(noticia);
    this.noticiasServicios.insertNoticia(noticia);
  }

}

