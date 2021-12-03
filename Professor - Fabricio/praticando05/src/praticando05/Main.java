package praticando05;


public class Main {

	public static void main(String[] args) {

			
		Lampada lampada = new Lampada();
		
		lampada.ligar();
		
		
		lampada.desligar();
		
		lampada.mostrarEstado();
		lampada.ligar();
		lampada.mostrarEstado();
	}

}
