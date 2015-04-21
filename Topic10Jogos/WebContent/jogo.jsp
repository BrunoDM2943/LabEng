<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="edu.fatec.*" import="java.util.Set"
	import="javax.servlet.ServletContext"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Jogo</title>
<link rel="stylesheet" type="text/css" href="./jogo.css">
</head>
<body>

	<jsp:useBean id="jogo" class="edu.fatec.Jogo" scope="page" />
	<jsp:setProperty name="jogo" property="*" />
	<div align="left">
	<form action="JogoController" method="get">
		<table id="tblFormJogo" cellspacing="5px" align="left">
			<tr>
				<td>Nome</td>
				<td><input type="text" name="nome"></td>
			</tr>
			<tr>
				<td>Dificuldade</td>
				<td>
					<select name="dificuldade">
					<%
						for(Dificuldade dificuldade : Dificuldade.values()){							
					%>
						<option value=<%=dificuldade.toString()%>><%=dificuldade.toString() %></option>
						
					<%					
							}
					%>
					</select>				
				</td>
			</tr>
			<tr>
				<td><input type="submit" name="cmd" value="adicionar" /></td>
				<td><input type="submit" name="cmd" value="pesquisar" /></td>
			</tr>

		</table>
	</form>
	</div>
	<br>
	<%
		if (request.getAttribute("jogo") != null) {
	%>
		Jogo encontrado = <%=request.getAttribute("jogo").toString() %>
	<%
		}
	%>
</body>
</html>