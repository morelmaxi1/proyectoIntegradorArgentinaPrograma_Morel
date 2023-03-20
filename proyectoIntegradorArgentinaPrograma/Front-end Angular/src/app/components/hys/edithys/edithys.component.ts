import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Hys } from 'src/app/models/hys';
import { HysService } from 'src/app/services/hys.service';

@Component({
  selector: 'app-edithys',
  templateUrl: './edithys.component.html',
  styleUrls: ['./edithys.component.css']
})
export class EdithysComponent {
  hys : Hys = null  ;
 
  constructor(private sHys : HysService, private activatedRouter : ActivatedRoute,
     private router : Router){}

ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.sHys.detail(id).subscribe(
  data =>{
    this.hys = data;
  },err =>{
    alert('Error al modificar experiencia');
    this.router.navigate(['']);
  }

)
  }

  onUpdate():void{
    const id = this.activatedRouter.snapshot.params['id'];
    this.sHys.update(id, this.hys).subscribe(
      data => {
        this.router.navigate(['']);
      }, err => {
        alert("Error al modificar experiencia");
        this.router.navigate(['']);
      }
    )
  }

}
