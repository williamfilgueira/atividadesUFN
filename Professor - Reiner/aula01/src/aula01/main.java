package aula01;

public class main {

	public static void main(String[] args) {

		Calculadora calc = new Calculadora();

		calc.setNumber1(10);
		calc.setNumber2(20);
		System.out.println("A soma entre o n�mero:" + calc.getNumber1() + "+" + calc.getNumber2() + "=" + calc.somar());
		System.out.println(
				"A subtra��o entre o n�mero:" + calc.getNumber1() + "+" + calc.getNumber2() + "=" + calc.diminuir());
		System.out.println(
				"A divis�o entre o n�mero:" + calc.getNumber1() + "+" + calc.getNumber2() + "=" + calc.dividir());
		System.out.println("A multiplica��o entre o n�mero:" + calc.getNumber1() + "+" + calc.getNumber2() + "="
				+ calc.multiplicar());
		System.out.println(calc.getNumber1());

	}

}
