package praticando06;

import classes.Funcionario;
import classes.Gerente;
import classes.Professor;
import classes.Programador;

public class Main {

	public static void main(String[] args) {

		Programador prog = new Programador();
		prog.nome = "William";
		prog.salario = 5000;
		prog.aumentarSalario();
		System.out.println("Ol� " + prog.nome + " seu salario atual �: " + prog.salario);
		prog.descontoSalarioDia();
		System.out.println(prog.nome+" seu sal�rio agora �:" + prog.salario);
		
		System.out.println("---------------------------------------");
		
		Professor prof = new Professor();
		prof.nome = "Carlos";
		prof.salario = 2000;
		prof.aumentarSalario();
		System.out.println("Professor: "+ prof.nome);
		System.out.println("Sal�rio: "+prof.salario);

		System.out.println("---------------------------------------");
		
		Gerente gerente = new Gerente();
		gerente.nome = "Gerentio";
		gerente.salario = 7000;
		System.out.println("Gerente:" + gerente.nome);
		System.out.println("Gerente:" + gerente.salario);
		gerente.aumentarSalario();
		System.out.println("Aumento!");
		System.out.println("Gerente:" + gerente.nome);
		System.out.println("Gerente:" + gerente.salario);
		gerente.descontoSalarioDia();
		System.out.println("Desconto!");
		System.out.println("Gerente:" + gerente.nome);
		System.out.println("Gerente:" + gerente.salario);
		
		
	}

}
