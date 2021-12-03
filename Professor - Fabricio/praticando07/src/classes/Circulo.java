package classes;

import interfaces.FormaGeometrica;

public class Circulo implements FormaGeometrica {

	public double raio;
	public double pi = 3.14;
	
	@Override
	public double area() {
		return pi* (raio*raio) ;
	}

	@Override
	public double comprimento() {
		return (2 * pi) * raio;
	}
	
	

 }

