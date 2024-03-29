import { Component, OnInit } from '@angular/core';
import { Persona } from 'src/app/models/persona.models';
import { PersonaService } from 'src/app/services/persona.service';
import { TokenService } from 'src/app/services/token.service';

@Component({
  selector: 'app-acerca-de',
  templateUrl: './acerca-de.component.html',
  styleUrls: ['./acerca-de.component.css']
})
export class AcercaDeComponent  implements OnInit{
  persona: Persona = null;
  constructor (public personaService: PersonaService){}
private tokenService : TokenService;
  isLogged=false;

  ngOnInit(): void {
    this.cargarPersona();
    if(this.tokenService.getToken()){
      this.isLogged = true;
    }else{
      this.isLogged = false;
    }
  }



  cargarPersona(){
    this.personaService.detail(1).subscribe(
      data=>{
        this.persona=data
      }
    )

  }

}
