package br.atos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServelet
 */
@WebServlet("/MyServelet")
public class MyServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyServelet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * 
	 *      configurando metodo GET, toda resposta GET ter� esse c�digo
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		add uma frase para dentro da variavel
		String curso = "Academia Java - UFN Atos";
		String voltar= "index.html"; //criando uma variav�l para poder voltar a p�gina
		
		response.setContentType("text/html"); // m�todo vindo do response
		PrintWriter printWriter = response.getWriter();// instanciando m�todo para imprimir na p�gina
		printWriter.println("<h1>Bem-vindo ao Servlet MyServlet</h1>");
		printWriter.println("<h2>Resposta do m�todo GET</h2>");
		printWriter.println("<h3>" + curso + "</h3>"); // concatenando escrita na p�gina com uma vari�vel que possui uma
														// frase como cont�do
		printWriter.println("<a href="+voltar+">VOLTAR</a>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * 
	 *      configurando metodo GET, toda resposta POST ter� esse c�digo
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//	recebendo um parametro "nome" e add dentro da variavel nome
//	recebendo um parametro "senha" e add dentro da variavel senha
		String nome = request.getParameter("nome");
		String numeroDobrado = request.getParameter("numeroDobrado");
		
//		pegando o parametro numero1 e numero2 convertendo para inteiro
		String numero1 = request.getParameter("numero1");
		int numero1Convertido = Integer.parseInt(numero1);
		
		String numero2 = request.getParameter("numero2");
		int numero2Convertido = Integer.parseInt(numero2);
		
//		instanciando a classe calculadora
		Calculadora calculadora = new Calculadora();
		
//		criando a resposta como page html com formata��o UTF-8 para acentua��o 		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

//		resposta HMTL
		PrintWriter printWriter = response.getWriter();
//		m�todo para add a classe PrintWriter valores em texto
		printWriter.append("<!DOCTYPE html>")
		.append("<html>\r\n")
		.append("<head>")
		.append("<title>Resposta HTTML do m�todo doPOST</title>")
		.append("</head>")
		.append("<body>")
		.append("Bem-vindo <strong>"+ nome +"</strong><br>")
		.append("Resposta do m�todo doPost<br>")
		.append("Nome: "+ nome +"<br> N�mero:"+ numeroDobrado + "<br>")  //add valor na variabel numero ao met�do da classe calculadora e convertendo seu valor de string para integer
		.append("N�mero dobrado "+calculadora.dobrarValor(Integer.parseInt(numeroDobrado))+ "<br>")
		.append("<span>--------------</span><br>")
		.append("<h2> Opera��es matem�ticas dos n�meros:" + numero1 + " e " + numero2 + "</h2>")
		.append("<h3>Soma:" + calculadora.somarValor(numero1Convertido, numero2Convertido) + "</h3>")//chamando os metodos e atribuindo os parametros recebidos do HTML
		.append("<h3>Subtra��o:" + calculadora.subtrairValor(numero1Convertido, numero2Convertido) + "</h3>") 
		.append("<h3>Multiplica��o:" + calculadora.multiplicarValor(numero1Convertido, numero2Convertido) + "</h3>")
		.append("<h3>Divis�o:" + calculadora.dividirValor(numero1Convertido, numero2Convertido) + "</h3>")
		.append("<body>")
		.append("</html>\r\n");
		
		
	}

}
