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

import co.unab.edu.models.entity.Profesion;
import co.unab.edu.models.service.ProfesionService;

@RestController
@RequestMapping("/api/profesiones")
public class ProfesionController {
	@Autowired
	private ProfesionService profesionService;
	
	@GetMapping("{id}")
	public Optional<Profesion> buscarPorId(@PathVariable Integer id) {
		return profesionService.findById(id);
	}
	
	@GetMapping("/listar")
	public List<Profesion> listar() {
		return  profesionService.findAll();
	}
	
	@PostMapping
	public Profesion guardar(@RequestBody Profesion profesion) {
		return profesionService.save(profesion);
	}
	
	@PutMapping("/actualizar/{id}")
	public Profesion actualizar(@RequestBody Profesion profesion, @PathVariable Integer id) {
		Profesion ProfesionBD = profesionService.findById(id).get();
		ProfesionBD.setId(profesion.getId());
				
		profesionService.save(ProfesionBD);
		return profesion;
	}
	
	@DeleteMapping("{id}")
	public void eliminar(@PathVariable Integer id) {
		profesionService.deleteById(id);
	}
}