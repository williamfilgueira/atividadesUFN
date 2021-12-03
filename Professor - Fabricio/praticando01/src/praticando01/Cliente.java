package praticando01;

public class Cliente {
	public String nome;
	public String telefone;
	private String cpf;
	public String endereco;
	public String email;
	private String senha;

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
