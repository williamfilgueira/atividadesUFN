package br.ufn.atos07ConnectionMYSQL.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;

public class ConnectionMYSQL {

	public java.sql.Connection connect;
	public java.sql.Statement stmt;
	public ResultSet rs;

//	criando metodo para realizar a conexão com o BD;
	public boolean connect(String address, String port, String dataBaseName, String user, String password) {
		boolean status = false;
		try {
			connect = DriverManager.getConnection("jdbc:mysql://" + address + ":" + port + "/" + dataBaseName + "?user="
					+ user + "&password=" + password + "&useTimezone=true&serverTimezone=UTC");
			status = true;
		} catch (Exception ex) {
			System.out.println("Exception: " + ex.getMessage());

		}
		return status;
	}

//	criando metodo generico para inserçoes alterações e exlusões
	public int executeUpdate(String query) {
		int status = 0;
		try {
			stmt = connect.createStatement();
			status = stmt.executeUpdate(query);
		} catch (Exception ex) {
			System.out.println("Exception:" + ex.getMessage());
		}
		return status;
	}

//	criando metodo para realizar consultas
	public ResultSet executeQuery(String query) {
		try {
			stmt = connect.createStatement();
			rs = stmt.executeQuery(query);
		} catch (Exception ex) {
			System.out.println("Exeception:" + ex.getMessage());
		}
		return rs;
	}

}
