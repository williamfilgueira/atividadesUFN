package br.atos.SpringSecurity.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.atos.SpringSecurity.Models.PessoaModel;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaModel, Long>
{
}
