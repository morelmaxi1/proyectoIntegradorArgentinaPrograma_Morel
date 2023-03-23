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

import com.portafolioMorel.mgv.Dto.dtoExperiencia;
import com.portafolioMorel.mgv.Entity.Experiencia;
import com.portafolioMorel.mgv.Security.Controller.Mensaje;
import com.portafolioMorel.mgv.Services.SExperiencia;

@RestController
@RequestMapping("explab")
@CrossOrigin(origins = "http://localhost:4200")
public class CExperiencia {

	@Autowired
	SExperiencia sExperiencia;

	@GetMapping("/lista")
	public ResponseEntity<List<Experiencia>> list() {
		List<Experiencia> list = sExperiencia.list();
		return new ResponseEntity(list, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody dtoExperiencia dtoExp) {
		if (StringUtils.isBlank(dtoExp.getNombreE()))
			return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		if (sExperiencia.existsByNombreE(dtoExp.getNombreE()))
			return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
		Experiencia experencia = new Experiencia(dtoExp.getNombreE(), dtoExp.getDescripcionE());
		sExperiencia.save(experencia);
		return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
	}

@GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!sExperiencia.existsByid(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = sExperiencia.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }

	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoExperiencia dtoExp) {

		if (!sExperiencia.existsByid(id))
			return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);

		if (sExperiencia.existsByNombreE(dtoExp.getNombreE())
				&& sExperiencia.getByNombreE(dtoExp.getNombreE()).get().getId() != id)
			return new ResponseEntity(new Mensaje("Essa Experiencia ya existe"), HttpStatus.BAD_REQUEST);

		if (StringUtils.isBlank(dtoExp.getNombreE()))
			return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);

		Experiencia experiencia = sExperiencia.getOne(id).get();
		experiencia.setNombreE(dtoExp.getNombreE());
		experiencia.setDescripcionE(dtoExp.getDescripcionE());

		sExperiencia.save(experiencia);

		return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		if (!sExperiencia.existsByid(id))
			return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);

		sExperiencia.delete(id);

		return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);

	}

}
