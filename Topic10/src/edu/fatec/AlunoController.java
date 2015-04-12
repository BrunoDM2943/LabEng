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
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext context = request.getSession().getServletContext();
		Object obj = context.getAttribute("lsAlunos");
		if (obj == null) {
			lsAlunos = new HashSet<Aluno>();
			context.setAttribute("lsAlunos", lsAlunos);
		} else{
			lsAlunos = (Set<Aluno>) obj;
		}

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

		response.setContentType( "text/html" );
		if(lsAlunos.add(aluno)){
			response.sendRedirect("aluno.jsp?add=Aluno " + aluno.getNome() + " adicionado com sucesso!" );
		}else{
			response.sendRedirect("aluno.jsp?add=Aluno " + aluno.getNome() + " já existia na base!" );
		}
		
		
		
	}

}
