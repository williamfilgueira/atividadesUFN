package classes;

import interfaces.FormaGeometrica;

public class Triangulo implements FormaGeometrica {

	public double base;
	public double altura;
	
	public double lado1;
	public double lado2;
	public double lado3;
	
	
	@Override
	public double area() {
		return (base * altura) / 2;
	}

	@Override
	public double comprimento() {
		return (lado1 + lado2 + lado3);
	}
	
}
