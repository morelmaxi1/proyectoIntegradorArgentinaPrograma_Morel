package com.portafolioMorel.mgv.Controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.portafolioMorel.mgv.Entity.Persona;
import com.portafolioMorel.mgv.Interfaz.IPersonaService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaControllers {
@Autowired IPersonaService ipersonaService;


@GetMapping("/personas/traer")
public List<Persona> getPersonas( ){
	return ipersonaService.getPersonas();
}
@PreAuthorize("hasRole('ADMIN')")
@PostMapping("/personas/crear")
public void createPersona(@RequestBody Persona persona) {
	ipersonaService.SavePersona(persona);
	System.out.println("se creo correctamente una persona"); 
}
@PreAuthorize("hasRole('ADMIN')")
@DeleteMapping("/personas/borrar/{id}" )
public void deletePersona(@PathVariable Long id) {
	ipersonaService.deletePersona(id);
	System.out.println("La persona fue elimenada correctamente");
}
@PreAuthorize("hasRole('ADMIN')")
@PutMapping("/personas/editar/{id}")
public Persona editarPersona(@PathVariable Long id, 
		                     @RequestParam("nombre")String nuevoNombre,
		                     @RequestParam("apellido")String nuevoApellido,
		                     @RequestParam("img")String nuevoImg) {
	Persona persona = ipersonaService.findPersona(id);
	
	persona.setNombre(nuevoNombre);
	persona.setApellido(nuevoApellido);
	persona.setImg(nuevoImg);
	ipersonaService.SavePersona(persona);
	return persona;
	}
@GetMapping("personas/traer/perfil")
public Persona findPersonas() {
	return ipersonaService.findPersona((long)4);
}

}
