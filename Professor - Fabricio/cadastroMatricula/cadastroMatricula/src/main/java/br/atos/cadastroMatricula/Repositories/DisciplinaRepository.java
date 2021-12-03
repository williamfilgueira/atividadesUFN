package br.atos.cadastroMatricula.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.atos.cadastroMatricula.Models.Disciplina;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long>
{
	
}
