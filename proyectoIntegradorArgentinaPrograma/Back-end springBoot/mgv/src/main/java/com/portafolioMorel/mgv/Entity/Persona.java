package com.portafolioMorel.mgv.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
public class Persona {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Size(min = 1, max = 50, message = " No cumple con la Longuitud")
	private String nombre;
	

	@NotNull
	@Size(min = 1, max = 50, message = " No cumple con la Longuitud")
	private String apellido;
	

	
	private String img;
	
	@NotNull
	private String descripcion;
	
	



	public Persona(int id, @NotNull @Size(min = 1, max = 50, message = " No cumple con la Longuitud") String nombre,
			@NotNull @Size(min = 1, max = 50, message = " No cumple con la Longuitud") String apellido, String img,
			@NotNull String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.img = img;
		this.descripcion = descripcion;
	}



	public Persona() {
	
	}



	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", img=" + img + "]";
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public String getImg() {
		return img;
	}



	public void setImg(String img) {
		this.img = img;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



}
