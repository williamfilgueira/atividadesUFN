package br.atos.cadastroMatricula.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.atos.cadastroMatricula.Models.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>
{
	
}
