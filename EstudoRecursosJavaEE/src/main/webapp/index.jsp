<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Recursos Avançados em Java</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>
<body>
	<h3>Recursos Avançados em Java</h3>
	<h5>${session.getMaxInactiveInterval() }</h5>
	<%= session.getMaxInactiveInterval() %>
	<table>
		<tr>
			<td> <a href="pages/capturarExcecoes.jsp">Capturar Execeções</a> </td>
								
		</tr>
		<tr>
			<td> <a href="pages/paginaPrincipal.jsp">Acesso ao Sistema (teste Filter)</a> </td>
		</tr>
		<tr>
			<td> <a href="pages/paginaPai.jsp">Carregar Página com jQuery</a> </td>
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