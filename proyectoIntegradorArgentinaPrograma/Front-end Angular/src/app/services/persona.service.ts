import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Persona } from '../models/persona.models';



@Injectable({
  providedIn: 'root'
})

export class PersonaService {
  
 URL = 'http://localhost:8080/personas/' ;
  constructor (private httpClient: HttpClient) { }



  public lista():Observable<Persona[]>{

    return this.httpClient.get<Persona[]>(this.URL + 'lista');
    
    }
    public detail(id: number):Observable<Persona>{
      return this.httpClient.get<Persona>(this.URL + `detail/${id}` );
    }
    
    public update(id:number,persona: Persona): Observable<any>{
      return this.httpClient.put<any>(this.URL + `update/${id}`,persona);
    
    }
   
}
