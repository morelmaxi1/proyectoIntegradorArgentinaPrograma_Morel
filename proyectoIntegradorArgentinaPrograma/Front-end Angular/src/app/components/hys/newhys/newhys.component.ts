import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Hys } from 'src/app/models/hys';
import { HysService } from 'src/app/services/hys.service';

@Component({
  selector: 'app-newhys',
  templateUrl: './newhys.component.html',
  styleUrls: ['./newhys.component.css']
})
export class NewhysComponent implements OnInit{
 nombre: string ;
porcentaje:number;


  constructor(private sHys: HysService, private router : Router){}



  ngOnInit(): void {
      
  }
  onCreate():void{
    const hys = new Hys( this.nombre, this.porcentaje);
    this.sHys.save(hys).subscribe(
      data =>{alert("Experiencia añadida");
      this.router.navigate(['']);
    },err =>{
      alert("fallo");
      this.router.navigate([''])
    }
    )
    
  }

}
