package br.rfp;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String curso = "Academia Java - UFN Atos";
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		printWriter.println("<h1>Bem-vindo ao Servlet MyServlet</h1>");
		printWriter.println("<h2>Resposta do método GET</h2>");
		printWriter.println("<h3>" + curso + "</h3>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");

		Calculadora calculadora = new Calculadora();

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		// RESPOSTA HTML
		PrintWriter printWriter = response.getWriter();
		printWriter.append("<!DCOTYPE html>").append("<html>\r\n").append("    <head>")
				.append("        <title>Resposta HTML do método doPost</title>").append("    </head>")
				.append("    <body>").append("       Bem-vindo <strong>" + nome + "</strong><br>")
				.append("       Resposta do método doPost<br>")
				.append("       User " + nome + " Senha: " + senha + "<br>")
				.append("       Senha dobrada " + calculadora.dobrarValor(Integer.parseInt(senha)) + "<br>")
				.append("    </body>").append("</html>\r\n");
	}

}
