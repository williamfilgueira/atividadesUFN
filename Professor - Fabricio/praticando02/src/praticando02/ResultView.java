package praticando02;

public class ResultView {

	public void showSun(Operacoes op) {
		
		System.out.println("A soma entre os números é:" + op.somar());

	}
	
	public void showDecrease(Operacoes operacoes) {
		System.out.println("A subtração entre os números é:" + operacoes.subtrair());

	}
	
	public void showMultiplication(Operacoes operacoes) {
		System.out.println("A multiplicação entre os números é:" + operacoes.multiplicar());

	}
	
	public void showDivision(Operacoes operacoes) {
		System.out.println("A divisão entre os números é:" + operacoes.dividir());

	}
	
	

}
