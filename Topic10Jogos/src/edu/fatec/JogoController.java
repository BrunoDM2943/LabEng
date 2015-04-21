package edu.fatec;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JogoController
 */
@WebServlet("/JogoController")
public class JogoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	Set<Jogo> lsJogos;
    
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	@SuppressWarnings("unchecked")
	public void init(ServletConfig config) throws ServletException {
		ServletContext context = config.getServletContext();
		Object obj = context.getAttribute("JOGOS");
		if (obj == null) {
			lsJogos = new HashSet<Jogo>();
			context.setAttribute("JOGOS", lsJogos);
		} else {
			lsJogos = (Set<Jogo>) obj;
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Jogo jogo = null;

		String cmd = request.getParameter("cmd");
		if ("adicionar".equals(cmd)) {
			lsJogos.add(carregarJogo(request));
		} else if ("pesquisa".equals(cmd)) {
			String nome = request.getParameter("nome");

			for (Jogo j : lsJogos) {
				if (j.getNome().equalsIgnoreCase(nome)) {
					jogo = j;
					break;
				}
			}
			request.setAttribute("jogo", jogo);			
		}
		response.setContentType("text/html");

		response.sendRedirect("jogo.jsp");
	}
	
	/**
	 * Carrega um jogo conforme o request passado
	 * 
	 * 
	 * @param request
	 * @return Jogo carregado
	 */
	private Jogo carregarJogo(HttpServletRequest request) {
		String nome = request.getParameter("nome");
		Dificuldade dificuldade = Dificuldade.valueOf(request.getParameter("dificuldade"));

		Jogo jogo = new Jogo();
		jogo.setNome(nome);
		jogo.setDificuldade(dificuldade);
		return jogo;
	}

}
