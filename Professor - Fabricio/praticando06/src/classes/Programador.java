package classes;

public class Programador extends Funcionario {

	
	
	@Override
	public void aumentarSalario() {
		salario = salario + 900;
	}
	
	@Override
	public void descontoSalarioDia() {
		salario = salario - 500;
	}

}
