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

import com.portafolioMorel.mgv.Dto.DtoHyS;
import com.portafolioMorel.mgv.Entity.HyS;
import com.portafolioMorel.mgv.Security.Controller.Mensaje;
import com.portafolioMorel.mgv.Services.Shys;

@RestController
@RequestMapping("/hys")
@CrossOrigin(origins = "https://frontendargen.web.app")
public class CHyS {
	
	@Autowired
	Shys sHys;
	
	
	@GetMapping("/lista")
	public ResponseEntity<List<HyS>> list() {
		List<HyS> list = sHys.list();
		return new ResponseEntity(list, HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody DtoHyS dtoHys) {
		if (StringUtils.isBlank(dtoHys.getNombre()))
			return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		if (sHys.existsByNombre(dtoHys.getNombre()))
			return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
		HyS hys = new HyS(dtoHys.getNombre(), dtoHys.getPorcentaje());
		sHys.save(hys);
		return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);

}
	@GetMapping("/detail/{id}")
    public ResponseEntity<HyS> getById(@PathVariable("id") int id){
        if(!sHys.existsByid(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        HyS hys = sHys.getOne(id).get();
        return new ResponseEntity(hys, HttpStatus.OK);
    }
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoHyS dtoHys) {

		if (!sHys.existsByid(id))
			return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);

		if (sHys.existsByNombre(dtoHys.getNombre())
				&& sHys.getByNombre(dtoHys.getNombre()).get().getId() != id)
			return new ResponseEntity(new Mensaje("Essa Experiencia ya existe"), HttpStatus.BAD_REQUEST);

		if (StringUtils.isBlank(dtoHys.getNombre()))
			return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);

		HyS hys = sHys.getOne(id).get();
		hys.setNombre(dtoHys.getNombre());
		hys.setPorcentaje(dtoHys.getPorcentaje());

		sHys.save(hys);

		return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		if (!sHys.existsByid(id))
			return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);

		sHys.delete(id);

		return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);

	}
	
}
