package br.atos.cadastroMatricula.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.atos.cadastroMatricula.Models.Aluno;
import br.atos.cadastroMatricula.Models.Disciplina;
import br.atos.cadastroMatricula.Models.Matricula;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long>
{
	public long countByDisciplina(Disciplina disciplina);
	
	public long countByDisciplinaAndAluno(Disciplina disciplina, Aluno aluno);
}
