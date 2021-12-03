package br.atos.SpringSecurity.Controller;

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

import br.atos.SpringSecurity.Models.PessoaModel;
import br.atos.SpringSecurity.Repository.PessoaRepository;

@RestController
@RequestMapping("/pessoas")
public class PessoaController
{
    @Autowired
    private PessoaRepository pessoaRepository;
    @GetMapping
    public List<PessoaModel> listar()
    {
        return pessoaRepository.findAll();
    }
    @GetMapping("/{id}")
    public Optional<PessoaModel> getPessoa(@PathVariable Long id) 
    {
        System.out.println(id);
        try
        {
            return pessoaRepository.findById(id);
        }
        catch (Exception e) 
        {
            return null;
        }
    }
    @PostMapping
    public PessoaModel adicionar(@RequestBody PessoaModel pessoa)
    {
        return pessoaRepository.save(pessoa);
    }
    @DeleteMapping("/{id}")
    void deletePessoa(@PathVariable Long id) 
    {
        pessoaRepository.deleteById(id);
    }
    @PutMapping("/{id}")
    PessoaModel updatePessoa(@RequestBody PessoaModel novaPessoa, @PathVariable Long id) 
    {
        PessoaModel p = pessoaRepository.getOne(id);
        p.setNome(novaPessoa.getNome());
        return pessoaRepository.save(p);
     }
}