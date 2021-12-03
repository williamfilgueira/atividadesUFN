package classes;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		Circulo circulo = new Circulo();
		circulo.raio = scan.nextDouble();

		System.out.println("Area: " + circulo.area());

		Quadrado quadrado = new Quadrado();
		quadrado.lado = scan.nextDouble();

		System.out.println("Perimetro:" + quadrado.comprimento());

		scan.close();

	}

}
