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
 * Servlet implementation class AlunoController
 */
@WebServlet(name = "/AlunoServlet", urlPatterns = "/AlunoController")
public class AlunoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Set<Aluno> lsAlunos;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AlunoController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	@SuppressWarnings("unchecked")
	public void init(ServletConfig config) throws ServletException {
		ServletContext context = config.getServletContext();
		Object obj = context.getAttribute("ALUNOS");
		if (obj == null) {
			lsAlunos = new HashSet<Aluno>();
			context.setAttribute("ALUNOS", lsAlunos);
		} else {
			lsAlunos = (Set<Aluno>) obj;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Aluno aluno = null;

		String cmd = request.getParameter("cmd");
		if ("adicionar".equals(cmd)) {
			lsAlunos.add(carregarAluno(request));
		} else if ("pesquisa".equals(cmd)) {
			String id = request.getParameter("id");

			for (Aluno a : lsAlunos) {
				if (a.getId() == Long.parseLong(id)) {
					aluno = a;
					break;
				}
			}
			request.setAttribute("aluno", aluno);
		} else if("remover".equals(cmd)) {
			String id = request.getParameter("id");
			aluno = new Aluno();
			aluno.setId(Long.parseLong(id));
			lsAlunos.remove(aluno);
			
		} else if("atualizar".equals(cmd)){
			aluno = carregarAluno(request);
			lsAlunos.remove(aluno);
			lsAlunos.add(aluno);
		}
		response.setContentType("text/html");

		response.sendRedirect("aluno.jsp");
	}

	private Aluno carregarAluno(HttpServletRequest request) {
		String id = request.getParameter("id");
		String ra = request.getParameter("ra");
		String nome = request.getParameter("nome");
		String idade = request.getParameter("idade");
		String sexo = request.getParameter("sexo");

		Aluno aluno = new Aluno();
		aluno.setId(Long.parseLong(id));
		aluno.setRa(ra);
		aluno.setNome(nome);
		aluno.setIdade(Integer.parseInt(idade));
		aluno.setSexo(sexo);

		return aluno;
	}

}
