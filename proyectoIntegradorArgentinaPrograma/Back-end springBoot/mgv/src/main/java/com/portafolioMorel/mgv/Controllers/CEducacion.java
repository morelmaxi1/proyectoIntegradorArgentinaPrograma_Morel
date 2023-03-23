package com.portafolioMorel.mgv.Controllers;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portafolioMorel.mgv.Dto.dtoEducacion;
import com.portafolioMorel.mgv.Entity.Educacion;
import com.portafolioMorel.mgv.Security.Controller.Mensaje;
import com.portafolioMorel.mgv.Services.SEducacion;

@RestController
@RequestMapping("educacion")
@CrossOrigin(origins = "http://localhost:4200")
public class CEducacion {
	@Autowired
	SEducacion sEducacion;
	
	@GetMapping("/lista")
	public ResponseEntity<List<Educacion>> list() {
		List<Educacion> list = sEducacion.list();
		return new ResponseEntity(list, HttpStatus.OK);
	}
	

	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody dtoEducacion dtoEdu) {
		if (StringUtils.isBlank(dtoEdu.getNombreEd()))
			return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		if (sEducacion.existsByNombreE(dtoEdu.getNombreEd()))
			return new ResponseEntity(new Mensaje("Esa educacion ya existe"), HttpStatus.BAD_REQUEST);
		Educacion educacion = new Educacion(dtoEdu.getNombreEd(), dtoEdu.getDescripcionEd());
		sEducacion.save(educacion);
		return new ResponseEntity(new Mensaje("Educacion agregada agregada"), HttpStatus.OK);
	}
	
	@GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if(!sEducacion.existsByid(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Educacion educacion = sEducacion.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoEdu) {

		if (!sEducacion.existsByid(id))
			return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);

		if (sEducacion.existsByNombreE(dtoEdu.getNombreEd())
				&& sEducacion.getByNombreEd(dtoEdu.getNombreEd()).get().getId() != id)
			return new ResponseEntity(new Mensaje("Esse dato ya existe"), HttpStatus.BAD_REQUEST);

		if (StringUtils.isBlank(dtoEdu.getNombreEd()))
			return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);

		Educacion educacion = sEducacion.getOne(id).get();
		educacion.setNombreEd(dtoEdu.getNombreEd());
		educacion.setDescripcionEd(dtoEdu.getDescripcionEd());

		sEducacion.save(educacion);

		return new ResponseEntity(new Mensaje("Educacion  actualizada"), HttpStatus.OK);
	}

	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		if (!sEducacion.existsByid(id))
			return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);

		sEducacion.delete(id);

		return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);

	}

}
