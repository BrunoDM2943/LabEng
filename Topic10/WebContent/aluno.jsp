<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="edu.fatec.*" import="java.util.Set"
	import="javax.servlet.ServletContext"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Aluno</title>
<link rel="stylesheet" type="text/css" href="./aluno.css">
</head>
<body>

	<jsp:useBean id="aluno" class="edu.fatec.Aluno" scope="page" />
	<jsp:setProperty name="aluno" property="*" />
	<form action="AlunoController" method="get">
		<table id="tblFormAluno" cellspacing="5px" align="left">
			<tr>
				<td>ID</td>
				<td colspan="4"><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>RA</td>
				<td colspan="4"><input type="text" name="ra"></td>
			</tr>
			<tr>
				<td>Nome</td>
				<td colspan="4"><input type="text" name="nome"></td>
			</tr>
			<tr>
				<td>Idade</td>
				<td colspan="4"><input type="text" name="idade"></td>
			</tr>
			<tr>
				<td>Sexo</td>
				<td colspan="4"><input type="text" name="sexo"></td>
			</tr>
			<tr>
				<td><input type="submit" name="cmd" value="adicionar" /></td>
				<td><input type="submit" name="cmd" value="pesquisar" /></td>
				<td><input type="submit" name="cmd" value="remover" /></td>
				<td><input type="submit" name="cmd" value="atualizar" /></td>
			</tr>

		</table>

	</form>

	<br>
	<%
		if (request.getAttribute("aluno") != null) {
	%>
	Aluno encontrado =
	<%=request.getAttribute("aluno").toString()%>
	<%
		}
	%>

	<br>
	<table id="tblAlunos" align="left">
		<tr>
			<th>ID</th>
			<th>RA</th>
			<th>Nome</th>
			<th>Idade</th>
			<th>Sexo</th>
		</tr>
		<%
			ServletContext context = request.getSession().getServletContext();
			Set<Aluno> lsAlunos = (Set<Aluno>) context.getAttribute("ALUNOS");
			if (lsAlunos != null) {
				for (Aluno a : lsAlunos) {
		%>
		<tr>
			<td><%=a.getId()%></td>
			<td><%=a.getRa()%></td>
			<td><%=a.getNome()%></td>
			<td><%=a.getIdade()%></td>
			<td><%=a.getSexo()%></td>
		</tr>
		<%
			}
			}
		%>
	</table>



</body>
</body>
</html>