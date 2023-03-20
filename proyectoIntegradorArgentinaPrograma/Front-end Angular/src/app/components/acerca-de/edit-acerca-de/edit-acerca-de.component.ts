import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Persona } from 'src/app/models/persona.models';
import { PersonaService } from 'src/app/services/persona.service';

@Component({
  selector: 'app-edit-acerca-de',
  templateUrl: './edit-acerca-de.component.html',
  styleUrls: ['./edit-acerca-de.component.css']
})
export class EditAcercaDeComponent implements OnInit {

persona : Persona = null;
constructor(private activatedRouter: ActivatedRoute, private personaService: PersonaService, private router : Router ){}



  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.personaService.detail(id).subscribe(
  data =>{
    this.persona= data;
  },err =>{
    alert('Error al modificar experiencia');
    this.router.navigate(['']);
  }
    )
  }
      
  
  onUpdate():void{
    const id = this.activatedRouter.snapshot.params['id'];
    this.personaService.update(id, this.persona).subscribe(
      data => {
        this.router.navigate(['']);
      }, err => {
        alert("Error al modificar experiencia");
        this.router.navigate(['']);
      }
    )
  }
  uploadImage($event:any){

  }
}
