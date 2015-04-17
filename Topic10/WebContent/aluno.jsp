<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="edu.fatec.*" import="java.util.Set" import="javax.servlet.ServletContext"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Aluno</title>
</head>
<body>
 
 <jsp:useBean id="aluno" class="edu.fatec.Aluno" scope="page" />
 <jsp:setProperty name="aluno" property="*"/>
<form action="AlunoController" method="get">
	ID <input type="text" name="id"><br>
	RA <input type="text" name="ra"><br>
	Nome <input type="text" name="nome"><br>
	Idade <input type="text" name="idade"><br>
	Sexo <input type="text" name="sexo"><p>
	
	<table>
	
	<% ServletContext context = request.getSession().getServletContext();
	   Set<Aluno> lsAlunos = (Set<Aluno>) context.getAttribute("ALUNOS");
	   if(lsAlunos != null){
	   for(Aluno a : lsAlunos){
	   %>
	<tr>
		<td><%= a.getId() %></td>
		<td><%= a.getRa() %></td>
		<td><%= a.getNome() %></td>
		<td><%= a.getIdade() %></td>
		<td><%= a.getSexo() %></td>	
	</tr>	
	<%}
	  }%>
	</table>
	
	<%= request.getParameter("resp") %>
</form>


</body>
</body>
</html>