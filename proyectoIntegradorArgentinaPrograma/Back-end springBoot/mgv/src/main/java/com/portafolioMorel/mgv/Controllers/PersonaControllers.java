package com.portafolioMorel.mgv.Controllers;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.portafolioMorel.mgv.Dto.DtoPersona;
import com.portafolioMorel.mgv.Dto.dtoExperiencia;
import com.portafolioMorel.mgv.Entity.Experiencia;
import com.portafolioMorel.mgv.Entity.Persona;
import com.portafolioMorel.mgv.Security.Controller.Mensaje;
import com.portafolioMorel.mgv.Services.ImpPersonaService;

@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = "https://frontendargen.web.app")
public class PersonaControllers {
	@Autowired
	ImpPersonaService iPersonaService;

	@GetMapping("/lista")
	public ResponseEntity<List<Persona>> list() {
		List<Persona> list = iPersonaService.list();
		return new ResponseEntity(list, HttpStatus.OK);
	}
	@PostMapping("/create")
	public ResponseEntity<Persona> create(@RequestBody DtoPersona dtoPersona) {
		if (StringUtils.isBlank(dtoPersona.getNombre()))
			return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		if (iPersonaService.existsByNombre(dtoPersona.getNombre()))
			return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
		Persona persona = new Persona();
		iPersonaService.save(persona);
		return new ResponseEntity(new Mensaje("Persona agregada"), HttpStatus.OK);
	}


	

@GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id){
        if(!iPersonaService.existsByid(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Persona persona = iPersonaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }

	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoPersona dtoPersona) {

		if (!iPersonaService.existsByid(id))
			return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);

		if (iPersonaService.existsByNombre(dtoPersona.getNombre())
				&& iPersonaService.getByNombre(dtoPersona.getNombre()).get().getId() != id)
			return new ResponseEntity(new Mensaje("Essa Persona ya existe"), HttpStatus.BAD_REQUEST);

		if (StringUtils.isBlank(dtoPersona.getNombre()))
			return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);

		Persona persona = iPersonaService.getOne(id).get();
		persona.setNombre(dtoPersona.getNombre());
		persona.setDescripcion(dtoPersona.getDescripcion());

		iPersonaService.save(persona);

		return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);
	}

	
}
