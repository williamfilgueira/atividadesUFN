package aula01;

public class Conta {
	public String nomeDono;
	private String cpf;
	public double saldo = 0;
	protected String ultimoAcesso;
	
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	public void sacar(double valor) {
		saldo = saldo - valor;
	}
	
	public void depositar(double valor) {
		saldo = saldo + valor;
	}
	
	public double retornaSaldo() {
		return saldo;
	}
}
