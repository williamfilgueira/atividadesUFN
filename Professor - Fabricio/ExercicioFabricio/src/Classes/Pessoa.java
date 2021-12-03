package Classes;

import java.util.Date;

public class Pessoa {

	protected int id;
	protected String nome;
	protected String endereco;
	protected String cidade;
	protected String uf;
	protected String foneFixo;
	protected String foneCelular;
	protected Date data;
	protected String cpf;
	protected String sexo;

	public Pessoa(int id, String nome, String endereco, String cidade, String uf, String foneFixo, String foneCelular,
			Date data, String cpf, String sexo) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.cidade = cidade;
		this.uf = uf;
		this.foneFixo = foneFixo;
		this.foneCelular = foneCelular;
		this.data = data;
		this.cpf = cpf;
		this.sexo = sexo;
	}

	public void inserir(int id, String nome, String endereco, String cidade, String uf,String foneFixo, String foneCelular, Date data, String cpf, String sexo) {
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.cidade = cidade;
		this.uf = uf;
		this.foneFixo = foneFixo;
		this.foneCelular = foneCelular;
		this.data = data;
		this.cpf = cpf;
		this.sexo = sexo;
	}

	public void alterar() {

	}

	public void excluir() {

	}

	public void recuperar() {

	}
}
