package praticando05;

public class Lampada {

	protected boolean ligada;

	public void ligar() {
		ligada = true;
	}

	public void desligar() {
		ligada = false;
	}

	public void mostrarEstado() {
		if(ligada) {
			System.out.println("A lampada est� ligada");
			
		}else {
			System.out.println("A lampada est� desligada");
		}
	}
}
