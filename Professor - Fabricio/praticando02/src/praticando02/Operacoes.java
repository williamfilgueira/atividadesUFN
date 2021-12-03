package praticando02;

public class Operacoes {

	private double n1;
	private double n2;
	private double n3;
	private double n4;
	private double total;
	
	
	
	
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getN1() {
		return n1;
	}
	public void setN1(double n1) {
		this.n1 = n1;
	}
	public double getN2() {
		return n2;
	}
	public void setN2(double n2) {
		this.n2 = n2;
	}
	public double getN3() {
		return n3;
	}
	public void setN3(double n3) {
		this.n3 = n3;
	}
	public double getN4() {
		return n4;
	}
	public void setN4(double n4) {
		this.n4 = n4;
	}

	public double somar() {
		total = n1 + n2 + n3 + n4; 
		return total;
	}
	
	public double subtrair() {
		total = n1 - n2 - n3 - n4;
		return total;
	}
	
	public double multiplicar() {
		total = n1 * n2 * n3 * n4;
		return total;
	}
	
	public double dividir() {
		total = n1 / n2 / n3 / n4; 
		return total;
	}
	
}
