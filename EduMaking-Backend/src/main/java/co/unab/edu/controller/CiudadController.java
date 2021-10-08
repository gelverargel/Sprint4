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
import co.unab.edu.models.entity.Ciudad;
import co.unab.edu.models.service.CiudadService;

@RestController
@RequestMapping("/api/ciudades")
public class CiudadController {
	@Autowired
	private CiudadService ciudadService;
	
	@GetMapping("{id}")
	public Optional<Ciudad> buscarPorId(@PathVariable Integer id) {
		return ciudadService.findById(id);
	}
	
	@GetMapping("/listar")
	public List<Ciudad> listar() {
		return  ciudadService.findAll();
	}
	
	@PostMapping
	public Ciudad guardar(@RequestBody Ciudad ins) {
		System.out.println(ins);
		return ciudadService.save(ins);
	}
	
	@PutMapping("/actualizar/{id}")
	public Ciudad actualizar(@RequestBody Ciudad ciudad, @PathVariable Integer id) {
		Ciudad ciudad_act = ciudadService.findById(id).get();
		ciudad_act.setNombre(ciudad.getNombre());
		ciudad_act.setEstado(ciudad.getEstado());
		ciudad_act.setPais(ciudad.getPais());
		
		ciudadService.save(ciudad_act);
		return ciudad;
	}
	
	// Si se va a quitar el eliminar, eliminar este método o comentarlo
	@DeleteMapping("{id}")
	public void eliminar(@PathVariable Integer id) {
		ciudadService.deleteById(id);
	}
}
