package com.portafolioMorel.mgv.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portafolioMorel.mgv.Entity.Persona;
import com.portafolioMorel.mgv.Interfaz.IPersonaService;
import com.portafolioMorel.mgv.Repository.IPersonaRepository;

@Service
public class ImpPersonaService implements IPersonaService{

	@Autowired 
	IPersonaRepository ipersonarepository;
	
	
	
	@Override
	public List<Persona> getPersonas() {
		List<Persona> listaPersona = ipersonarepository.findAll();
		return listaPersona;
	}

	@Override
	public void SavePersona(Persona persona) {
		ipersonarepository.save(persona);
	}

	@Override
	public void deletePersona(Long id) {
	  ipersonarepository.deleteById(id);
		
	}

	@Override
	public Persona findPersona( Long id) {
		Persona persona = ipersonarepository.findById(id).orElse(null);
		return  persona;
	}

	


}
