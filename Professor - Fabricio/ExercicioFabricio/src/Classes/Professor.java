package Classes;

import java.util.Date;

public class Professor extends Funcionario {

	protected int matricula;


	public Professor(int id, String nome, String endereco, String cidade, String uf, String foneFixo,
			String foneCelular, Date data, String cpf, String sexo) {
		super(id, nome, endereco, cidade, uf, foneFixo, foneCelular, data, cpf, sexo);
	}

	
	public Professor(int id, String nome, String endereco, String cidade, String uf, String foneFixo,
			String foneCelular, Date data, String cpf, String sexo, int matricula) {
		super(id, nome, endereco, cidade, uf, foneFixo, foneCelular, data, cpf, sexo);
	}



}
