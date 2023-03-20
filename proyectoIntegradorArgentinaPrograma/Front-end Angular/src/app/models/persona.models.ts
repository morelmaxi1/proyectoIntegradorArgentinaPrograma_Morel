export class Persona{
    update(id: any, persona: Persona) {
      throw new Error('Method not implemented.');
    }
    id?: number;
    nombre: String;
    apellido:String;
    img: String;
    descripcion: string;

    constructor(nombre:String, apellido:String, img:String, descripcion: string){
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
        this.descripcion = descripcion;
    }
}