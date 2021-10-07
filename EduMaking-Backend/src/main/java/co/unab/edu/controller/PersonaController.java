package co.unab.edu.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.unab.edu.models.entity.Persona;
import co.unab.edu.models.service.PersonaService;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {

	@Autowired
	private PersonaService personaService;
	
	@GetMapping("{id}")
	public Optional<Persona> buscarPorId(@PathVariable Integer id) {
		return personaService.findById(id);
	}
	
	@GetMapping("/listar")
	public List<Persona> listar() {
		return  personaService.findAll();
	}
	
	@PostMapping
	public Persona guardar(@RequestBody Persona persona) {
		return personaService.save(persona);
	}
	
	@DeleteMapping("{id}")
	public void eliminar(@PathVariable Integer id) {
		personaService.deleteById(id);
	}
	
	@PutMapping("/actualizar/{id}")
	public Persona actualizar(@RequestBody Persona persona, @PathVariable Integer id) {
		Persona PersonaBD = personaService.findById(id).get();
		PersonaBD.setIdPersona(persona.getIdPersona());
		PersonaBD.setTipoDoc(persona.getTipoDoc());
		PersonaBD.setNombreEmpresa(persona.getNombreEmpresa());
		PersonaBD.setTelEmpresa(persona.getTelEmpresa());
		PersonaBD.setEmailEmpresa(persona.getEmailEmpresa());
		PersonaBD.setNombrePersona(persona.getNombrePersona());
		PersonaBD.setTelPersona(persona.getTelPersona());
		PersonaBD.setEmailPersona(persona.getEmailPersona());
		PersonaBD.setCargoPersona(persona.getCargoPersona());
		PersonaBD.setProfesion(persona.getProfesion());
		PersonaBD.setClasif(persona.getClasif());
		PersonaBD.setPais(persona.getPais());
		PersonaBD.setCiudad(persona.getCiudad());
		PersonaBD.setRutPersona(persona.getRutPersona());
		PersonaBD.setInteres(persona.getInteres());
		PersonaBD.setEstado(persona.getEstado());
		
		personaService.save(PersonaBD);
		return persona;
	}
	
	
}
