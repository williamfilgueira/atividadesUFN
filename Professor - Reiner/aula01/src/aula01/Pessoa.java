package aula01;

public class Pessoa {
	public String cpf;
	public String nome;
	public int  altura;
	public int peso;
	
	public String andar() {
		peso += -1;
		return "andando";
	}
	
	public String comer() {
		peso += +1;
		return "comendo";
	}
	
}
