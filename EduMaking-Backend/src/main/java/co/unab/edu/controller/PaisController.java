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
import co.unab.edu.models.entity.Pais;
import co.unab.edu.models.service.PaisService;

@RestController
@RequestMapping("/api/paises")
public class PaisController {
	@Autowired
	private PaisService paisService;
	
	@GetMapping("{id}")
	public Optional<Pais> buscarPorId(@PathVariable String id) {
		return paisService.findById(id);
	}
	
	@GetMapping("/listar")
	public List<Pais> listar() {
		return  paisService.findAll();
	}
	
	@PostMapping
	public Pais guardar(@RequestBody Pais curso) {
		System.out.println(curso);
		return paisService.save(curso);
	}
	
	@PutMapping("/actualizar/{id}")
	public Pais actualizar(@RequestBody Pais pais, @PathVariable String id) {
		Pais pais_act = paisService.findById(id).get();
		pais_act.setNombre(pais.getNombre());
		pais_act.setContinente(pais.getContinente());
		pais_act.setCodigo(pais.getCodigo());
		
		paisService.save(pais_act);
		return pais;
	}
	
	// Si se va a quitar el eliminar, eliminar este método o comentarlo
	@DeleteMapping("{id}")
	public void eliminar(@PathVariable String id) {
		paisService.deleteById(id);
	}
}
