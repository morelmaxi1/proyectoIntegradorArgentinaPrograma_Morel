package com.portafolioMorel.mgv.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Experiencia {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String nombreE;
private String descripcion;


//contructores
public Experiencia() {
}


public Experiencia(String nombreE, String descripcion) {
	
	this.nombreE = nombreE;
	this.descripcion = descripcion;
}


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public String getNombreE() {
	return nombreE;
}


public void setNombreE(String nombreE) {
	this.nombreE = nombreE;
}


public String getDescripcion() {
	return descripcion;
}


public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}


}
