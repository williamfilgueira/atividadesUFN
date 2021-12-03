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

import br.atos.cadastroMatricula.Models.Aluno;
import br.atos.cadastroMatricula.Repositories.AlunoRepository;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

	@Autowired
	AlunoRepository alunoRepository;
	
	@GetMapping
	public List<Aluno> buscaAlunos()
	{
		return alunoRepository.findAll();
	}
	
	@PostMapping
	public Aluno add(@RequestBody Aluno aluno)
	{
		return alunoRepository.save(aluno);
	}
	
	@GetMapping("/{id}")
	public Optional<Aluno> getAluno(@PathVariable Long id)
	{
		return alunoRepository.findById(id);
	}
	
	@PutMapping("/{id}")
	public Aluno atualizarAluno(@RequestBody Aluno aluno, @PathVariable Long id) {
//		criando uma nova pessoa e atribuindo pessoa do parametro para p
		Aluno a = alunoRepository.getById(id);
		a.setNome(aluno.getNome());
		return alunoRepository.save(a);
	}
	
	@DeleteMapping("/{id}")
	public void deletarAluno(@PathVariable Long id) {
		System.out.println("id");
		alunoRepository.deleteById(id);
	}
}
