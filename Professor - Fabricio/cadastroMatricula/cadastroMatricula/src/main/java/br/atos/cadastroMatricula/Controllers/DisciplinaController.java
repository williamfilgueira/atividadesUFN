package br.atos.cadastroMatricula.Controllers;

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

import br.atos.cadastroMatricula.Models.Disciplina;
import br.atos.cadastroMatricula.Repositories.DisciplinaRepository;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaController {

	@Autowired
	DisciplinaRepository disciplinaRepository;
	
	
	@GetMapping
	public List<Disciplina> buscaDisciplinas()
	{
		return disciplinaRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Disciplina> getAluno(@PathVariable Long id)
	{
		return disciplinaRepository.findById(id);
	}
	
	@PostMapping
	public Disciplina add(@RequestBody Disciplina disciplina)
	{
		return disciplinaRepository.save(disciplina);
	}
	
	@PutMapping("/{id}")
	public Disciplina atualizarDisciplina(@RequestBody Disciplina disciplina, @PathVariable Long id) {
//		criando uma nova pessoa e atribuindo pessoa do parametro para p
		Disciplina disc = disciplinaRepository.getById(id);
		disc.setNome(disciplina.getNome());
		disc.setVagas(disciplina.getVagas());
		return disciplinaRepository.save(disc);
	}
	
	@DeleteMapping("/{id}")
	public void deletarDisciplina(@PathVariable Long id) {
		System.out.println("id");
		disciplinaRepository.deleteById(id);
	}
	
}
