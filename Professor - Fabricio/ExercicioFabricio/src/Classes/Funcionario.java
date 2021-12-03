package Classes;

import java.util.Date;

public class Funcionario extends Pessoa {

	public Funcionario(int id, String nome, String endereco, String cidade, String uf, String foneFixo,
			String foneCelular, Date data, String cpf, String sexo) {
		super(id, nome, endereco, cidade, uf, foneFixo, foneCelular, data, cpf, sexo);
		// TODO Auto-generated constructor stub
	}
	protected String cargo;
	protected String setor;
	protected String salario;
	
	
	

	

}
