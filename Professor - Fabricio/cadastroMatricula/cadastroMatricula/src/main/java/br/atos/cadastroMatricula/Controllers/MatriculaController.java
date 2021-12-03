package br.atos.cadastroMatricula.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.atos.cadastroMatricula.Models.Aluno;
import br.atos.cadastroMatricula.Models.Disciplina;
import br.atos.cadastroMatricula.Models.Matricula;
import br.atos.cadastroMatricula.Repositories.AlunoRepository;
import br.atos.cadastroMatricula.Repositories.DisciplinaRepository;
import br.atos.cadastroMatricula.Repositories.MatriculaRepository;

@RestController
@RequestMapping("/matricula")
public class MatriculaController {
	@Autowired
	DisciplinaRepository disciplinaRepository;

	@Autowired
	AlunoRepository alunoRepository;

	@Autowired
	MatriculaRepository matriculaRepository;

	@GetMapping
	public List<Matricula> buscaMatriculas() {
		return matriculaRepository.findAll();
	}

	@PostMapping
	public String add(@RequestParam Long idDisciplina, @RequestParam Long idAluno) {
		try {

			Optional<Disciplina> disciplina = disciplinaRepository.findById(idDisciplina);

			Optional<Aluno> aluno = alunoRepository.findById(idAluno);

			Matricula matricula = new Matricula();
			matricula.setAluno(aluno.get());
			matricula.setDisciplina(disciplina.get());

			long vagas = disciplina.get().getVagas() - matriculaRepository.countByDisciplina(disciplina.get());

			if (vagas == 0) {

				return "Não existem mais vagas disponivel";
			}

			if (matriculaRepository.countByDisciplinaAndAluno(disciplina.get(), aluno.get()) > 0) {
				return null;
			}

			Matricula m = matriculaRepository.save(matricula);
			return "Cadastrado com sucesso";

		} catch (Exception e) {
			return "Erro ao cadastrar matricula";
		}
	}

//	@PutMapping("/{id}")
//	public Optional<Matricula> atualizarMatricula(@PathVariable Long id, @RequestBody Matricula matriculaNova) {
//
//		return matriculaRepository.findById(id).map(matricula -> {
//			matricula.setAluno(matriculaNova.getAluno());
//			matricula.setDisciplina(matriculaNova.getDisciplina());
//			Matricula update = matriculaRepository.save(matricula);
//			return matriculaRepository.save(update);
//		});
//
//	}

	@DeleteMapping("/{id}")
	public void deletarMatricula(@PathVariable Long id) {
		System.out.println("id");
		matriculaRepository.deleteById(id);
	}
}
