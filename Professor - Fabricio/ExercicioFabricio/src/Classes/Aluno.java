package Classes;

import java.util.Date;

public class Aluno extends Pessoa {

	public Aluno(int id, String nome, String endereco, String cidade, String uf, String foneFixo, String foneCelular,
			Date data, String cpf, String sexo) {
		super(id, nome, endereco, cidade, uf, foneFixo, foneCelular, data, cpf, sexo);
		// TODO Auto-generated constructor stub
	}
	protected int classe;
	protected int media;
	protected boolean status;

	

}
