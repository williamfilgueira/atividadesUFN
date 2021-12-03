package View;

import java.util.List;
import java.util.Scanner;

import controller.ClienteController;
import controller.FornecedorController;
import model.Cliente;
import model.Fornecedor;

public class LojaView {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

//iniciando o hibernate
//		entidades
		Cliente cliente = new Cliente();
		ClienteController clienteCRUD = new ClienteController();

		Fornecedor fornecedor = new Fornecedor();
		FornecedorController fornecedorCRUD = new FornecedorController();

//		variaveis
		int respOpcao;
		int respOperacao;
		int respIDCliente;
		String nomeCliente;
		String telefoneCliente;
		String emailCliente;
		int respSaida = 0;
		
		int respIDFornecedor;
		String nomeFornecedor;
		String telefoneFornecedor;
		String emailFornecedor;

		clienteCRUD.setup();
		fornecedorCRUD.setup();
//criando laço de repetição para sempre retornar as opções até o usuario não querer mais
		do {
			System.out.println(
					"=================================================================================================");
			System.out.println("========================= BEM VINDO =========================");
			System.out.println("=============================================================");
			System.out.println("================== SELECIONE A OPERAÇÃO =====================");
			System.out.println("============= [1] CLIENTE | [2] FORNECEDOR ==================");
			respOpcao = scan.nextInt();

			if (respOpcao == 1) {
				System.out.println("========= SELECIONADO:" + respOpcao + "=======================");
				System.out.println("========= QUAL OPERAÇÃO DESEJA FAZER? ====================");
				System.out.println("=============================================================");
				System.out.println(
						"== [1] CONSULTAR TODOS == [2] VISUALIZAR POR ID == [3] + NOVO == [4] ATUALIZAR == [5] DELETAR===========================");
				respOperacao = scan.nextInt();

				System.out.println("=============================================================");
				System.out.println("SELECIONADO:" + respOperacao);
				System.out.println("=============================================================");

				// seleção da operação
				switch (respOperacao) {
				// primeira opção consultando no banco todos os clientes
				case 1:
					List<Cliente> listaCliente = clienteCRUD.listAll();
					for (Cliente c : listaCliente) {
						System.out.println("==================================");
						System.out.println("ID:" + c.getId());
						System.out.println("Nome:" + c.getNome());
						System.out.println("Telefone:" + c.getTelefone());
						System.out.println("Email:" + c.getEmail());
						System.out.println("==================================");
					}
					System.out.println("== DESEJA REPETIR? \n [1] SIM [2] NÃO");
					respSaida = scan.nextInt();

					break;
				// visualizar cliente por ID
				case 2:
					System.out.println("==============================================");
					System.out.println("== ENTRE COM O ID DO CLIENTE: ");
					respIDCliente = scan.nextInt();
					cliente = clienteCRUD.read(respIDCliente);
					System.out.println("NOME: " + cliente.getNome());
					System.out.println("TELEFONE: " + cliente.getId());
					System.out.println("EMAIL: " + cliente.getEmail());

					System.out.println("==================================");
					System.out.println("== DESEJA REPETIR? \n [1] SIM [2] NÃO");
					respSaida = scan.nextInt();
					System.out.println("==================================");

					break;

				// cadastrar um novo cliente
				case 3:
					System.out.println("====== CADASTRO DE CLIENTE =======");
					System.out.println("==================================");
					System.out.println("== ENTRE COM O NOME DO CLIENTE:");
					nomeCliente = scan.next();
					cliente.setNome(nomeCliente);

					System.out.println("==================================");
					System.out.println("== ENTRE COM O TELEFONE DO CLIENTE:");
					telefoneCliente = scan.next();
					cliente.setTelefone(telefoneCliente);

					System.out.println("==================================");
					System.out.println("== ENTRE COM O EMAIL DO CLIENTE:");
					emailCliente = scan.next();
					cliente.setEmail(emailCliente);
					clienteCRUD.create(cliente);

					System.out.println(cliente);
					System.out.println("== DESEJA REPETIR? \n [1] SIM [2] NÃO");
					respSaida = scan.nextInt();

					break;

//atualiar cliente por ID				
				case 4:
					System.out.println("==========================================");
					System.out.println("======= ENTRE COM O ID DO CLIENTE ========");
					respIDCliente = scan.nextInt();
					cliente.setId(respIDCliente);

					System.out.println("ENTRE COM O NOME DO CLIENTE:");
					nomeCliente = scan.next();
					cliente.setNome(nomeCliente);

					System.out.println("==================================");
					System.out.println("ENTRE COM O TELEFONE DO CLIENTE:");
					telefoneCliente = scan.next();
					cliente.setTelefone(telefoneCliente);

					System.out.println("==================================");
					System.out.println("ENTRE COM O EMAIL DO CLIENTE:");
					emailCliente = scan.next();
					cliente.setEmail(emailCliente);

					clienteCRUD.update(cliente);

					System.out.println("== DESEJA REPETIR? \n [1] SIM [2] NÃO");
					respSaida = scan.nextInt();

					break;

				// deletar cliente
				case 5:
					System.out.println("===================== ENTRE COM O ID DO CLIENTE =========================");
					System.out.println();
					respIDCliente = scan.nextInt();
					clienteCRUD.delete(respIDCliente);

					System.out.println("== DESEJA REPETIR? \n [1] SIM [2] N ÃO");
					respSaida = scan.nextInt();
				}
				
			//INICIO FORNECEDOR ***************************************8
			}else {
				System.out.println("========= SELECIONADO:" + respOpcao + "=======================");
				System.out.println("========= QUAL OPERAÇÃO DESEJA FAZER? ====================");
				System.out.println("=============================================================");
				System.out.println(
						"== [1] CONSULTAR TODOS == [2] VISUALIZAR POR ID == [3] + NOVO == [4] ATUALIZAR == [5] DELETAR ===========================");
				respOperacao = scan.nextInt();

				System.out.println("=============================================================");
				System.out.println("SELECIONADO:" + respOperacao);
				System.out.println("=============================================================");

				// seleção da operação
				switch (respOperacao) {
				// primeira opção consultando no banco todos os fornecedores
				case 1:
					List<Fornecedor> listaFornecedor = fornecedorCRUD.listAll();
					for (Fornecedor f : listaFornecedor) {
						System.out.println("==================================");
						System.out.println("ID:" + f.getId());
						System.out.println("Nome:" + f.getNome());
						System.out.println("Telefone:" + f.getTelefone());
						System.out.println("Email:" + f.getEmail());
						System.out.println("==================================");
					}
					System.out.println("== DESEJA REPETIR? \n [1] SIM [2] NÃO");
					respSaida = scan.nextInt();

					break;
				// visualizar fornecedor por ID
				case 2:
					System.out.println("==============================================");
					System.out.println("== ENTRE COM O ID DO FORNECEDOR: ");
					respIDFornecedor = scan.nextInt();
					fornecedor = fornecedorCRUD.read(respIDFornecedor);
					System.out.println("NOME: " + fornecedor.getNome());
					System.out.println("TELEFONE: " + fornecedor.getId());
					System.out.println("EMAIL: " + fornecedor.getEmail());

					System.out.println("==================================");
					System.out.println("== DESEJA REPETIR? \n [1] SIM [2] NÃO");
					respSaida = scan.nextInt();
					System.out.println("==================================");

					break;

				// cadastrar um novo Fornecedor
				case 3:
					System.out.println("====== CADASTRO DE FORNECEDOR =======");
					System.out.println("==================================");
					System.out.println("== ENTRE COM O NOME DO FORNECEDOR:");
					nomeFornecedor = scan.next();
					fornecedor.setNome(nomeFornecedor);

					System.out.println("==================================");
					System.out.println("== ENTRE COM O TELEFONE DO FORNECEDOR:");
					telefoneFornecedor = scan.next();
					cliente.setTelefone(telefoneFornecedor);

					System.out.println("==================================");
					System.out.println("== ENTRE COM O EMAIL DO FORNECEDOR:");
					emailFornecedor = scan.next();
					fornecedor.setEmail(emailFornecedor);
					fornecedorCRUD.create(fornecedor);

					System.out.println("== DESEJA REPETIR? \n [1] SIM [2] NÃO");
					respSaida = scan.nextInt();

					break;

//atualizar fornecedor por ID				
				case 4:
					System.out.println("==========================================");
					System.out.println("======= ENTRE COM O ID DO FORNECEDOR ========");
					respIDFornecedor = scan.nextInt();
					fornecedor.setId(respIDFornecedor);

					System.out.println("ENTRE COM O NOME DO FORNECEDOR:");
					nomeFornecedor = scan.next();
					fornecedor.setNome(nomeFornecedor);

					System.out.println("==================================");
					System.out.println("ENTRE COM O TELEFONE DO FORNECEDOR:");
					telefoneFornecedor = scan.next();
					fornecedor.setTelefone(telefoneFornecedor);

					System.out.println("==================================");
					System.out.println("ENTRE COM O EMAIL DO FORNECEDOR:");
					emailFornecedor = scan.next();
					fornecedor.setEmail(emailFornecedor);

					fornecedorCRUD.update(fornecedor);

					System.out.println("== DESEJA REPETIR? \n [1] SIM [2] NÃO");
					respSaida = scan.nextInt();

					break;

				// deletar fornecedor
				case 5:
					System.out.println("===========================================================");
					System.out.println("=========    ENTRE COM O ID DO FORNECEDOR =====================");
					respIDFornecedor= scan.nextInt();
					fornecedorCRUD.delete(respIDFornecedor);

					System.out.println("== DESEJA REPETIR? \n [1] SIM [2] NÃO");
					respSaida = scan.nextInt();
				}
			}
//opção para cadastro de fornecedor
				
		} while (respSaida == 1);

		scan.close();

	}

}
