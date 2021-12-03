package classes;

import interfaces.FormaGeometrica;

public class Quadrado implements FormaGeometrica {

	
	public double lado;
	
	@Override
	public double area() {
		return lado * lado;
	}

	@Override
	public double comprimento() {
		return 4 * lado;
	}

}
