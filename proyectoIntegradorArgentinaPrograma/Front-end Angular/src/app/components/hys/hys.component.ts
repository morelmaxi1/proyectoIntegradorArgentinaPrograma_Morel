import { Component, OnInit } from '@angular/core';
import { Hys } from 'src/app/models/hys';
import { HysService } from 'src/app/services/hys.service';
import { TokenService } from 'src/app/services/token.service';

@Component({
  selector: 'app-hys',
  templateUrl: './hys.component.html',
  styleUrls: ['./hys.component.css']
})
export class HysComponent implements OnInit{
  hys: Hys[] = [];

constructor(private sHys: HysService, private tokenService: TokenService){}


isLogged = false;

ngOnInit(): void {
  this.cargarHabilidad();
    if(this.tokenService.getToken()){
      this.isLogged = true;
    }else{
      this.isLogged = false;
    }
}

cargarHabilidad():void{
  this.sHys.lista().subscribe(data => {this.hys = data;})
}

delete(id?: number){
  if(id != undefined){
    this.sHys.delete(id).subscribe(
      data =>{
        this.cargarHabilidad();
      },err =>{
        alert("no se pudo borrar la experiencia");
      }
    )
  }
}

}
