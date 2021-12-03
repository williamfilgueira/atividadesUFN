package praticando01;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class main {

	public static void main(String[] args) {
		
		Scanner ler = new Scanner(System.in);
		Cliente cliente = new Cliente();
		
		System.out.println("=======================================================");

		System.out.println("================== FIXA DE CADASTRO ===================");

		System.out.println("=======================================================");
		
		System.out.println("Entre com o seu nome");
		
		cliente.nome = ler.nextLine();

		System.out.println("Entre com o seu telefone");		
		
		cliente.telefone = ler.nextLine();
		
		System.out.println("Entre com o nome seu cpf");
		
		String numeroCpf = ler.nextLine();
		cliente.setCpf(numeroCpf); 
		
		System.out.println("Entre com o seu endereço ");
		
		cliente.endereco = ler.nextLine();
		
		System.out.println("Entre com o seu email");

		cliente.email = ler.nextLine();
		
		System.out.println("Entre com uma senha");
		
		String senha = ler.nextLine();
		
		cliente.setSenha(senha);
		
		
		System.out.println("============= $ CLIENTE CADASTRADO COM SUCESSO $ ==========");
		
		System.out.println("Nome do cliente:"+ cliente.nome);
		System.out.println("Telefone do cliente:"+ cliente.telefone);
		System.out.println("Cpf:"+cliente.getCpf());
		System.out.println("Endereço:"+ cliente.endereco);
		System.out.println("email:"+ cliente.email);
		
		System.out.println("=============================================================");
		
		
		
		
	}

}
