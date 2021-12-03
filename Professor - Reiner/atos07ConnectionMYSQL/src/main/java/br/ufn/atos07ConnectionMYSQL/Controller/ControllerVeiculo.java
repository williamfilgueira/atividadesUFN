package br.ufn.atos07ConnectionMYSQL.Controller;

import java.util.Scanner;

import br.ufn.atos07ConnectionMYSQL.Connection.ConnectionMYSQL;

public class ControllerVeiculo {

//	importando a classa ConnectionMYSQL e instanciando ela
//	atribuindo seu valor a vareavel mysql
	ConnectionMYSQL mysql;

	public ControllerVeiculo() {
		mysql = new ConnectionMYSQL();
	}

	public static void main(String[] args) {
//chamando a classa scann
		Scanner scan = new Scanner(System.in);
//		variavel para resposta inicial do programa
		int resp = 1;

		while( resp != 1) {
			
			System.out.println("Deseja se conectar ao banco?");
			System.out.print("( 1 ) SIM");
			System.out.println("( 0 ) NÃO");
			resp = scan.nextInt();
			System.out.println("========================");
			resp++;
			
			try {
				ControllerVeiculo cVeiculo = new ControllerVeiculo();
				cVeiculo.conectar();
				System.out.println("========================");
				
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			}
			
			
		}

	}

	public void conectar() {
		boolean connected = mysql.connect("localhost", "3306", "estacionamento2", "root", "123456");
		if (connected) {
			System.out.println("Base de dados conectada.");
		} else {
			System.out.println("Base de dados não conectada.");
		}
	}

}
