package com.portafolioMorel.mgv.Security.Service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portafolioMorel.mgv.Security.Entity.Rol;
import com.portafolioMorel.mgv.Security.Enums.RolNombre;
import com.portafolioMorel.mgv.Security.Repository.IRolRepository;

@Service
@Transactional
public class RolService {
	@Autowired
	IRolRepository irolRepository;
	
	public Optional<Rol> getByRolNombre(RolNombre rolNombre){
		
		return irolRepository.findByRolNombre(rolNombre);
		
	}
	public void save (Rol rol) {
		irolRepository.save(rol);
	}

}
