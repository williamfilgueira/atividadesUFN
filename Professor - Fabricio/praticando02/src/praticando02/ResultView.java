package praticando02;

public class ResultView {

	public void showSun(Operacoes op) {
		
		System.out.println("A soma entre os n�meros �:" + op.somar());

	}
	
	public void showDecrease(Operacoes operacoes) {
		System.out.println("A subtra��o entre os n�meros �:" + operacoes.subtrair());

	}
	
	public void showMultiplication(Operacoes operacoes) {
		System.out.println("A multiplica��o entre os n�meros �:" + operacoes.multiplicar());

	}
	
	public void showDivision(Operacoes operacoes) {
		System.out.println("A divis�o entre os n�meros �:" + operacoes.dividir());

	}
	
	

}
