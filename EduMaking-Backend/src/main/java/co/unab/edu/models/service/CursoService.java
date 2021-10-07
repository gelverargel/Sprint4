package co.unab.edu.models.service;

import java.util.List;
import java.util.Optional;
import co.unab.edu.models.entity.Curso;

public interface CursoService {
	
	// Para listar todos los cursos
	public List<Curso>findAll();
	
	// Para buscar/listar un curso en especifico
	public Optional<Curso>findById(String id);
	
	// Para agregar un curso a la base de datos
	public Curso save(Curso curso);
	
	// Para eliminar un curso de la base de datos
	public void deleteById(String id);
	
}
