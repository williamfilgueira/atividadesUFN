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

import br.atos.ufn.SpringAPI.Models.Aluno;
import br.atos.ufn.SpringAPI.Repositories.AlunoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Api(value = "Swagger2RestController", description = "REST API relacionada ao CRUD de Aluno")
@RestController
@RequestMapping("/alunos")
public class AlunoController {

	@Autowired
	private AlunoRepository alunoRepository;

	@ApiOperation(value = "Retorna lista de alunos cadastrados", response = Iterable.class, tags = "getAluno")
	@GetMapping
	public List<Aluno> listar() {
		return alunoRepository.findAll();

	}

	@ApiOperation(value = "Retonar aluno de acordo com o ID(int) que é recebido por URL cadastradas", response = Iterable.class, tags = "getAluno")
	@GetMapping("/{id}")
	public Optional<Aluno> listarAlunosId(@PathVariable Long id) {
		try {
			return alunoRepository.findById(id);
		} catch (Exception exception) {
			return null;
		}
	}

	@ApiOperation(value = "Cria um aluno pelo RequestBody", response = Iterable.class, tags = "postAluno")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Aluno cadastrar(@RequestBody Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
	@ApiOperation(value = "Altera um aluno, recebendo os dados do aluno no requestBody e o ID no PathVariable", response = Iterable.class, tags = "putAluno")	
	@PutMapping("/{id}")
	public Aluno atualizarAluno(@RequestBody Aluno aluno, @PathVariable Long id) {
//		criando uma nova pessoa e atribuindo pessoa do parametro para para o novo objeto
		Aluno a = alunoRepository.getById(id);
		a.setNome(aluno.getNome());
		return alunoRepository.save(a);
	}
	
	@ApiOperation(value = "Exclusão de aluno pelo ID informado no (@PathVariable)", response = Iterable.class, tags = "deleteAluno")
	@DeleteMapping("/{id}")
	public void deletarAluno(@PathVariable Long id) {
		System.out.println("id");
		alunoRepository.deleteById(id);
	}
}
