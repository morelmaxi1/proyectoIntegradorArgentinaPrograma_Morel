package com.portafolioMorel.mgv.Dto;

import javax.validation.constraints.NotBlank;

public class DtoPersona {


	
	@NotBlank
	private String nombre;
	

	
	@NotBlank
	private String apellido;
	

	@NotBlank
	private String img;
	
	@NotBlank
	private String descripcion;

	public DtoPersona(@NotBlank String nombre, @NotBlank String apellido, @NotBlank String img,
			@NotBlank String descripcion) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.img = img;
		this.descripcion = descripcion;
	}

	public DtoPersona() {
		
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
