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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.atos.ufn.SpringAPI.Models.Pessoa;
import br.atos.ufn.SpringAPI.Repositories.PessoaRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//anotações setando a controlle da classe e criaçao de doc para API
@Api(value = "Swagger2RestController", description = "Rest API relacionada aos CRUD de PESSOAS!")
@RestController
@RequestMapping("/pessoas") // criando a rota da controller ex. http://localhost8080/pessoas
public class PessoaController {
	/*
	 * 
	 * //criando a requisição para listar pessoas
	 * 
	 * @GetMapping public String listar() { return "Testando API com Spring Boot"; }
	 */

	@Autowired
	private PessoaRepository pessoaRepository;

	@ApiOperation(value = "Retorna todas as pessas cadastradas", response = Iterable.class, tags = "getPessoas")
	@GetMapping
	public List<Pessoa> listar() {
		return pessoaRepository.findAll();
		
	}
	
	
	@ApiOperation(value = "Retorna pessoa conforme o ID(int) recebido da URL(Pathvariable) cadastradas", response = Iterable.class, tags = "getPessoas")
	@GetMapping("/{id}")
	public Optional<Pessoa> listaPessoaId(@PathVariable Long id) {

		try {
			return pessoaRepository.findById(id);
		} catch (Exception e) {
			return null;
		}
	}

	@ApiOperation(value = "Cadastra uma nova pessoa em um banco de dados", response = Iterable.class, tags = "postPessoas")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Pessoa cadastrar(@RequestBody Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

	@ApiOperation(value = "Exclusão da pessoa pelo ID informado no (@PathVariable)", response = Iterable.class, tags = "deletePessoas")
	@DeleteMapping("/{id}")
	public void deletarPessoa(@PathVariable Long id) {
		System.out.println("id");
		pessoaRepository.deleteById(id);
	}

	@ApiOperation(value = "Altera uma pessoa, recebendo os dados da pessoa no requestBody e o ID no PathVariable", response = Iterable.class, tags = "putPessoas")	
	@PutMapping("/{id}")
	public Pessoa atualizarPessoa(@RequestBody Pessoa pessoa, @PathVariable Long id) {
//		criando uma nova pessoa e atribuindo pessoa do parametro para p
		Pessoa p = pessoaRepository.getById(id);
		p.setNome(pessoa.getNome());
		return pessoaRepository.save(p);
	}

}
