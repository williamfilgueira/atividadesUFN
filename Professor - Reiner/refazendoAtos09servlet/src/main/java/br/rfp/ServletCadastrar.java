package br.rfp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletCadastrar
 */
@WebServlet("/ServletCadastrar")
public class ServletCadastrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Connection connection;
	private Statement statement;
	ResultSet rs;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCadastrar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		criando a p�gina de resposta
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		conectar();
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	private void conectar() {
		try {
			String address = "localhost";
			String port = "3306";
			String dataBaseName = "javaee";
			String user = "root";
			String password = "123456";

			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://" + address + ":" + port + "/" + dataBaseName
					+ "?user=" + user + "&password=" + password + "&useTimezone=true&serverTimezone=UTC");
			statement = connection.createStatement();

		} catch (Exception ex) {
			System.out.println("Exception: " + ex.getMessage());
		}

	}
	
	
	// Para inserções, alterações e exclusões   
    public int executeUpdate(String query) {     
        int status = 0;
        try {
        	statement = connection.createStatement();           
            status = statement.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
        return status;
    }
    
    // Para consultas
    public ResultSet executeQuery(String query) {
        try {
        	statement = connection.createStatement();
            rs = statement.executeQuery(query);
        } catch (SQLException ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
        return rs;   
    }

}
