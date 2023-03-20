import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Hys } from '../models/hys';

@Injectable({
  providedIn: 'root'
})
export class HysService {

  HySURL = 'http://localhost:8080/hys/'
  
  constructor(private httpClient: HttpClient) { }


   public lista():Observable<Hys[]>{

    return this.httpClient.get<Hys[]>(this.HySURL + 'lista');
    
    }

    public detail(id: number):Observable<Hys>{
      return this.httpClient.get<Hys>(this.HySURL + `detail/${id}` );
    }
    public save(hys:Hys):Observable<any>{
      return this.httpClient.post<any>(this.HySURL + 'create', hys);
    }

    public update(id:number,hys: Hys): Observable<any>{
      return this.httpClient.put<any>(this.HySURL + `update/${id}`,hys);
    
    }
    public delete(id:number):Observable<any>{
      return this.httpClient.delete<any>(this.HySURL + `delete/${id}`);
    }

}
