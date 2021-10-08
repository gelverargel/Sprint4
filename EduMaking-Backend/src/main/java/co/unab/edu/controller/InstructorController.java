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
import co.unab.edu.models.entity.Instructor;
import co.unab.edu.models.service.InstructorService;

@RestController
@RequestMapping("/api/instructores")
public class InstructorController {
	@Autowired
	private InstructorService instructorService;
	
	@GetMapping("{id}")
	public Optional<Instructor> buscarPorId(@PathVariable Integer id) {
		return instructorService.findById(id);
	}
	
	@GetMapping("/listar")
	public List<Instructor> listar() {
		return  instructorService.findAll();
	}
	
	@PostMapping
	public Instructor guardar(@RequestBody Instructor ins) {
		System.out.println(ins);
		return instructorService.save(ins);
	}
	
	@PutMapping("/actualizar/{id}")
	public Instructor actualizar(@RequestBody Instructor ins, @PathVariable Integer id) {
		Instructor ins_act = instructorService.findById(id).get();
		ins_act.setNombre(ins.getNombre());
		ins_act.setTelef(ins.getTelef());
		ins_act.setEmail(ins.getEmail());
		ins_act.setProfesion(ins.getProfesion());
		ins_act.setfInicioExp(ins.getfInicioExp());
		ins_act.setPais(ins.getPais());
		ins_act.setCiudad(ins.getCiudad());
		ins_act.setEstado(ins.getEstado());
		
		instructorService.save(ins_act);
		return ins;
	}
	
	// Si se va a quitar el eliminar, eliminar este método o comentarlo
	@DeleteMapping("{id}")
	public void eliminar(@PathVariable Integer id) {
		instructorService.deleteById(id);
	}
}
