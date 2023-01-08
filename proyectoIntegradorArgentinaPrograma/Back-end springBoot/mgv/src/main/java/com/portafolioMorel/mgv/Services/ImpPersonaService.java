package com.portafolioMorel.mgv.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portafolioMorel.mgv.Entity.Persona;
import com.portafolioMorel.mgv.Interfaz.IPersonaService;
import com.portafolioMorel.mgv.Repository.IPersonaRepository;

@Service
public class ImpPersonaService implements IPersonaService{

	@Autowired 
	IPersonaRepository Ipersonarepository;
	
	
	
	@Override
	public List<Persona> getPersona() {
		List<Persona> listaPersona = Ipersonarepository.findAll();
		return listaPersona;
	}

	@Override
	public void SavePersona(Persona persona) {
		Ipersonarepository.save(persona);
	}

	@Override
	public void deletePersona(Long id) {
	  Ipersonarepository.deleteById(id);
		
	}

	@Override
	public Persona findPersona(Long id) {
       Persona persona = Ipersonarepository.findById(id).orElse(null);
		return persona;
	}

}
