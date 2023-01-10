package com.portafolioMorel.mgv.Interfaz;

import java.util.List;

import com.portafolioMorel.mgv.Entity.Persona;

public interface IPersonaService {
	//Trae una lista de Persona
	public List<Persona> getPersonas();	
	
	//Guarda un objeto de Persona
	public void SavePersona(Persona persona);
	
	//Elimina un objeto por Id
	public void deletePersona(Long id);
	
	//buscar una persona por id
	public Persona findPersona(Long id);

	

	





	

}
