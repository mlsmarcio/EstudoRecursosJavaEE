<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Recursos Avan�ados em Java</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>
<body>
	<h3>Recursos Avan�ados em Java</h3>
	<h5>${session.getMaxInactiveInterval() }</h5>
	<%= session.getMaxInactiveInterval() %>
	<table>
		<tr>
			<td> <a href="pages/capturarExcecoes.jsp">Capturar Exece��es</a> </td>
								
		</tr>
		<tr>
			<td> <a href="pages/paginaPrincipal.jsp">Acesso ao Sistema (teste Filter)</a> </td>
		</tr>
		<tr>
			<td> <a href="pages/paginaPai.jsp">Carregar P�gina com jQuery</a> </td>
		</tr>
		<tr>
			<td> <a href="pages/progresbar.jsp">Progress Bar</a> </td>
		</tr>
		<tr>
			<td> <a href="pages/upload.jsp">Upload</a> </td>
		</tr>
		
		<tr>
			<td> <a href="pages/ServletAutenticacao?deslogar=true">Deslogar</a> </td>
		</tr>
		
	</table>


	
</body>
</html>