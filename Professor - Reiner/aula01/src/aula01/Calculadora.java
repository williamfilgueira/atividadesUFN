package aula01;

public class Calculadora {
	private double number1;
	private double number2;

	public double somar() {
		return number1 + number2;
	}

	public double diminuir() {
		return number1 - number2;

	}

	public double multiplicar() {
		return number1 * number2;

	}

	public double dividir() {
		return number1 / number2;

	}

	
	
	public double getNumber1() {
		return number1;
	}

	public double getNumber2() {
		return number2;
	}

	public void setNumber1(double number1) {
		this.number1 = number1;
	}

	public void setNumber2(double number2) {
		this.number2 = number2;
	}
	
	

}
