package com.portafolioMorel.mgv.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter

@Entity
public class Persona {
	
	public Persona(Long id, @NotNull @Size(min = 1, max = 50, message = " No cumple con la Longuitud") String nombre,
			@NotNull @Size(min = 1, max = 50, message = " No cumple con la Longuitud") String apellido,
			@Size(min = 1, max = 50, message = " No cumple con la Longuitud") String img) {
		
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.img = img;
	}



	public Persona() {
	
	}



	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", img=" + img + "]";
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
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



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 1, max = 50, message = " No cumple con la Longuitud")
	private String nombre;
	

	@NotNull
	@Size(min = 1, max = 50, message = " No cumple con la Longuitud")
	private String apellido;
	

	
	@Size(min = 1, max = 50, message = " No cumple con la Longuitud")
	private String img;
	
}
