package praticando02;

import javax.swing.JOptionPane;

public class App {

	public static void main(String[] args) {
		
		System.out.println("CALCULANDO 4 NÚMEROS");
		
		ResultView result = new ResultView();
		Operacoes op = new Operacoes();
		
		
		op.setN1(Double.parseDouble(JOptionPane.showInputDialog("Digite o primeiro número:")));
		op.setN2(Double.parseDouble(JOptionPane.showInputDialog("Digite o segundo número:")));
		op.setN3(Double.parseDouble(JOptionPane.showInputDialog("Digite o terceiro número:")));
		op.setN4(Double.parseDouble(JOptionPane.showInputDialog("Digite o quarto número:")));
		
		
		result.showSun(op);
		result.showDecrease(op);
		result.showMultiplication(op);
		result.showDivision(op);
		
	}

}
