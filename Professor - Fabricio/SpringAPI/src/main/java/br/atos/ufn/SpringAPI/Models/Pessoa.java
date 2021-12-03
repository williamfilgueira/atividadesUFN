package br.atos.ufn.SpringAPI.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Pessoa {

	// criando o atributos e identificando seus anotações
	@ApiModelProperty(notes = "É o ID da pessoa, é autoincremento...", name = "id", required = true)
	@Id // gerando ir automáticamente
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

//	referenciando a coluna na tabela e dando parametro a anotação, dizendo que não pode ser nulo este valor.s
	@ApiModelProperty(notes = "Nome de Pessoa", name = "nome", required = true, value = "Nome da Pessoa")
	@Column(nullable = false)
	private String nome;

//	metodos get and sets
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
