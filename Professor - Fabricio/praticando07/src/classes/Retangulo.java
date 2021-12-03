package classes;

import interfaces.FormaGeometrica;

public class Retangulo implements FormaGeometrica{

	public double base;
	public double altura;
	
	@Override
	public double area() {
		return base * altura ;
	}

	@Override
	public double comprimento() {
		return 2 * base + 2 * altura;
	}

	
	
}
