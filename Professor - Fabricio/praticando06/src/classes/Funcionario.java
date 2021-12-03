package classes;

public abstract class Funcionario {

	
	public double salario;
	public String nome;
	
	
	public abstract void aumentarSalario();
	
	public void descontoSalarioDia() {
		salario = salario - 100;
	}
}
