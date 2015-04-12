<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="edu.fatec.*"%>
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
	
	<input type="submit" name="cmdAdd" value="Adicionar" /> <p>
	
	<%= request.getParameter("add") %>
</form>


</body>
</html>