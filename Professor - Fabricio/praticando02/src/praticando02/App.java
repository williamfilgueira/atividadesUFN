package praticando02;

import javax.swing.JOptionPane;

public class App {

	public static void main(String[] args) {
		
		System.out.println("CALCULANDO 4 N�MEROS");
		
		ResultView result = new ResultView();
		Operacoes op = new Operacoes();
		
		
		op.setN1(Double.parseDouble(JOptionPane.showInputDialog("Digite o primeiro n�mero:")));
		op.setN2(Double.parseDouble(JOptionPane.showInputDialog("Digite o segundo n�mero:")));
		op.setN3(Double.parseDouble(JOptionPane.showInputDialog("Digite o terceiro n�mero:")));
		op.setN4(Double.parseDouble(JOptionPane.showInputDialog("Digite o quarto n�mero:")));
		
		
		result.showSun(op);
		result.showDecrease(op);
		result.showMultiplication(op);
		result.showDivision(op);
		
	}

}
