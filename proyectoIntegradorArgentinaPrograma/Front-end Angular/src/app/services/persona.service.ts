import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { persona } from '../models/persona.models';

@Injectable({
  providedIn: 'root'
})
export class PersonaService {
 URL = 'localhost:8080/personas/' ;
  constructor (private http: HttpClient) { }



public getPersona():Observable<persona> {
  return this.http.get<persona>(this.URL + 'traer/perfil');
}
}
