package br.ufn.atos06maven05;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Template {

	ConectionMySQLR mysqlr;

	public Template() {
		mysqlr = new ConectionMySQLR();
	}

	public static void main(String[] args) {
		try {

//			intanciando a clase template e chamando metodo para se conectar ao BD
			Template template = new Template();
			template.conectar();
			
			
			Veiculo veiculo = new Veiculo();
			
			veiculo.setMarca("Brasileirissima");
			veiculo.setModelo("RTX-45");
			veiculo.setPlaca("LYO-9900");
			veiculo.setAno_fabricacao("2000/12/20");
			
			template.inserir(veiculo);
			template.consultar();


		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
	}

//	metodo criado para se conectar com o banco
	public void conectar() {
		boolean connected = mysqlr.connect("localhost", "3306", "estacionamento", "root", "123456");
		if (connected) {
			System.out.println("Base de dados conectada.");
		} else {
			System.out.println("Base de dados não conectada.");
		}
	}

	public void inserir(Veiculo veiculo) {
		String query = "INSERT INTO veiculo(marca, modelo, placa, ano_fabricacao)"
	+ "values ('"+veiculo.getMarca()+"','"+veiculo.getModelo()+"','"+veiculo.getPlaca()+"','"+ veiculo.getAno_fabricacao()+"')";
		int status = mysqlr.executeUpdate(query);
		if(status == 1) {
			System.out.println("Dados inseridos com sucesso!");
		} else {
			System.out.println("Erro ao inserir dados!");
		}
	}
//	metdo para realizar uma consulta no BD
	public void consultar() {
        ResultSet rs = mysqlr.executeQuery("SELECT * FROM veiculo");
        if(rs != null) {
        	try {
        		while(rs.next()) {
//        			referenciando a coluna pelo indece
        			System.out.println("Id:"+ rs.getString(1));
//        			ou pelo nome
        			System.out.println("Marca: "+rs.getString("marca"));
        			System.out.println("Modelo: "+rs.getString("modelo"));
        			System.out.println("Placa: "+ rs.getString("placa"));
        			System.out.println("Ano de Fabricação: "+ rs.getDate("ano_fabricacao"));
        		}
        	}catch (SQLException e) {
        		System.out.println(e);
        	}
        }

	}
	
	public void altertar(Veiculo veiculo, int ID) {
		int status;
		String query = "UPDATE Veiculo SET marca='"+veiculo.getMarca() + "',"
				+ "modelo="+ veiculo.getModelo()+ "',"+ "placa="+veiculo.getPlaca()+"',"
				+"ano_fabricacao"+ veiculo.getAno_fabricacao() + "'"+"WHERE id="+ID;
		status = mysqlr.executeUpdate(query);
		if(status == 1) {
			System.out.println("Dados alterados com sucesso!");
		}else {
			System.out.println("Erro ao alterar dados!");
		}
	}
	
	public void excluir(int ID) {
		String query = "DELETE FROM Veiculo WHERE id="+ID;
		int status = mysqlr.executeUpdate(query);
		if(status ==1) {
			System.out.println("Dados excluídos com sucesso");
		}else {
			System.out.println("Erro ao exlcuir dados!");
		}
	}

}
