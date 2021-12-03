package br.atos.ufn.SpringAPI.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.atos.ufn.SpringAPI.Models.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>{

}
