import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EditAcercaDeComponent } from './components/acerca-de/edit-acerca-de/edit-acerca-de.component';
import { EditeducacionComponent } from './components/educacion/editeducacion/editeducacion.component';
import { NeweducacionComponent } from './components/educacion/neweducacion/neweducacion.component';
import { EditExperienciaComponent } from './components/experiencia/edit-experiencia/edit-experiencia.component';
import { NewExperienciaComponent } from './components/experiencia/new-experiencia/new-experiencia.component';
import { HomeComponent } from './components/home/home.component';
import { EdithysComponent } from './components/hys/edithys/edithys.component';
import { NewhysComponent } from './components/hys/newhys/newhys.component';
import { LoginComponent } from './components/login/login.component';

const routes: Routes = [
  {path:'', component: HomeComponent},
  {path:'login', component: LoginComponent},
  {path:'nuevaexpe',component: NewExperienciaComponent},
  {path:'editexp/:id',component: EditExperienciaComponent},
  {path:'nuevaedu',component: NeweducacionComponent},
  {path:'editedu/:id',component: EditeducacionComponent},
  {path:'nuevaHys',component: NewhysComponent},
  {path:'edithys/:id',component: EdithysComponent},
  {path:'editAcercaDe/:id',component: EditAcercaDeComponent},





];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
