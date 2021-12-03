package classes;

public class Gerente extends Funcionario{

	@Override
	public void aumentarSalario() {
		salario += 1000;
	}
	
	@Override
	public void descontoSalarioDia() {
		salario = salario - 200;
	}

	
	
	
}
