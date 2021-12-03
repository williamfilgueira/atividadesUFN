package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import conectionMYSQL.ConectionMYSQL;
import interfaceVeiculo.Veiculo;

public class Template {

	ConectionMYSQL mysql;

	public Template() {
		mysql = new ConectionMYSQL();
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Template template = new Template();
		Veiculo veiculo = new Veiculo();

		template.conectar();
		System.out.println("*** PROGRAMA PARA CADASTRO DE VEICULOS ***");
		System.out.println("****************************************");

		System.out.println("SELECIONE UMA OPÇÃO PARA COMEÇAR");
		System.out.println("****************************************");
		System.out.println("[1] INSERIR - [2] CONSULTAR - [3] ALTERAR - [4] DELETAR");
		int resp = scan.nextInt();

		switch (resp) {
		case 1:
			System.out.println("Entre com a marca do carro:");
			String marca = scan.next();
			veiculo.setMarca(marca);

			System.out.println("Entre com o modelo do carro:");
			String modelo = scan.next();
			veiculo.setModelo(modelo);

			System.out.println("Entre com a placa do carro:");
			String placa = scan.next();
			veiculo.setPlaca(placa);

			System.out.println("Entre com o ano do " + resp + "° carro:");
			String ano = scan.next();
			veiculo.setAno_fabricacao(ano);

			template.inserir(veiculo);
			break;
		case 2:
			template.consultar();
			break;
		case 3:
			Veiculo veiculoAlt = new Veiculo();
			System.out.println("Entre com o ID do carro:");
			int id = scan.nextInt();
			System.out.println("Entre com a marca do carro:");
			String marcaAlt = scan.next();
			veiculoAlt.setMarca(marcaAlt);

			System.out.println("Entre com o modelo do carro:");
			String modeloAlt = scan.next();
			veiculoAlt.setModelo(modeloAlt);

			System.out.println("Entre com a placa do carro:");
			String placaAlt = scan.next();
			veiculoAlt.setPlaca(placaAlt);

			System.out.println("Entre com o ano do " + resp + "° carro:");
			String anoAlt = scan.next();
			veiculoAlt.setAno_fabricacao(anoAlt);

//		System.out.println(marcaAlt+"\n"+modeloAlt+"\n"+placaAlt+"\n"+anoAlt+id);

			template.alterar(veiculoAlt, id);
			break;
		case 4:
			System.out.println("Entre com ID do carro para deletar");
			int idExcluir = scan.nextInt();
			template.excluir(idExcluir);
			break;
		}

	}

//	metodo criado para se conectar com o banco
	public void conectar() {
		boolean connected = mysql.connect("localhost", "3306", "estacionamento2", "root", "123456");
		if (connected) {
			System.out.println("Base de dados conectada.");
		} else {
			System.out.println("Base de dados não conectada.");
		}
	}

//	metodo para inserir dados
	public void inserir(Veiculo veiculo) {
		String query = "INSERT INTO Veiculos (marca, modelo, placa, ano_fabricacao)" + "values ('" + veiculo.getMarca()
				+ "','" + veiculo.getModelo() + "','" + veiculo.getPlaca() + "','" + veiculo.getAno_fabricacao() + "')";
		int status = mysql.executeUpdate(query);
		if (status == 1) {
			System.out.println("Dados inseridos com sucesso!");
		} else {
			System.out.println("Erro ao inserir dados!");
		}
	}

//	metodo para consultar os dados
	public void consultar() {
		ResultSet rs = mysql.executeQuery("SELECT * FROM Veiculos");
		if (rs != null) {
			try {
				while (rs.next()) {
					// É possível referenciar a coluna pelo índice
					System.out.println("Id: " + rs.getString(1));
					// Ou pelo nome
					System.out.println("Marca: " + rs.getString("marca"));
					System.out.println("Modelo: " + rs.getString("modelo"));
					System.out.println("Placa: " + rs.getString("placa"));
					System.out.println("Ano de fabricação: " + rs.getString("ano_fabricacao"));
					System.out.println();
				}
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
	}

	public void alterar(Veiculo veiculo, int ID){
        int status;
        String query = "UPDATE Veiculos SET marca='" + veiculo.getMarca() + "', "
                    + "modelo='" + veiculo.getModelo() + "', placa='" + veiculo.getPlaca() + "'"+"',ano_fabricacao='"+veiculo.getAno_fabricacao()
                    + "WHERE id=" + ID;
        status = mysql.executeUpdate(query);
        if (status == 1) {
            System.out.println("Dados alterados com sucesso!");
        } else {
            System.out.println("Erro ao alterar dados!");
        }
    }

	public void excluir(int ID) {
		String query = "DELETE FROM Veiculos WHERE id=" + ID;
		int status = mysql.executeUpdate(query);
		if (status == 1) {
			System.out.println("Dados excluídos com sucesso!");
		} else {
			System.out.println("Erro ao excluir dados!");
		}
	}
}
