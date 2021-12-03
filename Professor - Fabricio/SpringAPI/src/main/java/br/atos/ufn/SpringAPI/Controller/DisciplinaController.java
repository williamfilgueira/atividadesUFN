package br.atos.ufn.SpringAPI.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.atos.ufn.SpringAPI.Models.Disciplina;
import br.atos.ufn.SpringAPI.Repositories.DisciplinaRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Api(value = "Swagger2RestController", description = "REST API relacionada ao CRUD de Aluno")
@RestController
@RequestMapping("/disciplina")
public class DisciplinaController {

	@Autowired
	private DisciplinaRepository discRepository;
	
	@ApiOperation(value = "Retorna lista de disciplina cadastradas", response = Iterable.class, tags = "getDisciplina")
	@GetMapping
	public List<Disciplina> listar() {
		return discRepository.findAll();
	}
	
	@ApiOperation(value = "Retonar disciplina de acordo com o ID(int) que é recebido por URL cadastradas", response = Iterable.class, tags = "getDisciplina")
	@GetMapping("/{id}")
	public Optional<Disciplina> listarDisciplinaId(@PathVariable Long id) {
		try {
			return discRepository.findById(id);
		} catch (Exception exception) {
			return null;
		}
	}
	
	@ApiOperation(value = "Cadastra aluno, passando valores pelo RequestBody", response = Iterable.class, tags = "posttAluno")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Disciplina cadastrar(@RequestBody Disciplina disc) {
		return discRepository.save(disc);
	}
	
	@ApiOperation(value = "Altera uma disciplina, recebendo os dados da disc no requestBody e o ID no PathVariable", response = Iterable.class, tags = "putDisciplina")	
	@PutMapping("/{id}")
	public Disciplina atualizarAluno(@RequestBody Disciplina disc, @PathVariable Long id) {
//		criando uma nova pessoa e atribuindo pessoa do parametro para p
		Disciplina disciplina = discRepository.getById(id);
		disciplina.setNome(disciplina.getNome());
		return discRepository.save(disciplina);
	}
	
	@ApiOperation(value = "Exclusão de uma disciplina pelo ID informado no (@PathVariable)", response = Iterable.class, tags = "deleteDisciplina")
	@DeleteMapping("/{id}")
	public void deletarAluno(@PathVariable Long id) {
		System.out.println("id");
		discRepository.deleteById(id);
	}
}
