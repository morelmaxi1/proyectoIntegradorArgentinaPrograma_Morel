import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Educacion } from 'src/app/models/educacion';
import { EducacionService } from 'src/app/services/educacion.service';

@Component({
  selector: 'app-neweducacion',
  templateUrl: './neweducacion.component.html',
  styleUrls: ['./neweducacion.component.css']
})
export class NeweducacionComponent implements OnInit{

  nombreEd : string = '';
  descripcionEd:string = '';
  

  constructor(private educacionS: EducacionService, private router : Router){}






  ngOnInit(): void {
    
  }

  onCreate():void{
    const edu = new Educacion( this.nombreEd, this.descripcionEd);
    this.educacionS.save(edu).subscribe(
      data =>{alert("estudio añadido");
      this.router.navigate(['']);
    },err =>{
      alert("fallo");
      this.router.navigate([''])
    }
    )
    
  }

}
