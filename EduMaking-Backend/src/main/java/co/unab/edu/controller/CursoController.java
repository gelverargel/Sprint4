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
import co.unab.edu.models.entity.Curso;
import co.unab.edu.models.service.CursoService; 

@RestController
@RequestMapping("/api/cursos")
public class CursoController {
	@Autowired
	private CursoService cursoService;
	
	@GetMapping("{id}")
	public Optional<Curso> buscarPorId(@PathVariable String id) {
		return cursoService.findById(id);
	}
	
	@GetMapping("/listar")
	public List<Curso> listar() {
		return  cursoService.findAll();
	}
	
	@PostMapping
	public Curso guardar(@RequestBody Curso curso) {
		System.out.println("Curso: "+curso);
		return cursoService.save(curso);
	}
	
	@PutMapping("/actualizar/{id}")
	public Curso actualizar(@RequestBody Curso curso, @PathVariable String id) {
		Curso curso_act = cursoService.findById(id).get();
		curso_act.setInstructor(curso.getInstructor());
		curso_act.setNombre(curso.getNombre());
		curso_act.setContenido(curso.getContenido());
		curso_act.setDuracion(curso.getDuracion());
		
		cursoService.save(curso_act);
		return curso;
	}
	
	// Si se va a quitar el eliminar, eliminar este método o comentarlo
	@DeleteMapping("{id}")
	public void eliminar(@PathVariable String id) {
		cursoService.deleteById(id);
	}
}
