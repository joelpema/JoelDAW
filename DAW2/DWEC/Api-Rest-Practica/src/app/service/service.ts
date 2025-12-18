import { Iwelcome } from './../interfaces/iwelcome.interface';
import { Iresult } from './../interfaces/iresult.interface';
import { inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { lastValueFrom, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class Service {
  
  private baseUrl: string = 'https://peticiones.online/api/users';
  httpClient = inject(HttpClient)

  constructor(){  }

  getAllUsersWithPromise(): Promise<Iresult[]> {
        return lastValueFrom(this.httpClient.get<Iresult[]>(this.baseUrl))
    }



}
